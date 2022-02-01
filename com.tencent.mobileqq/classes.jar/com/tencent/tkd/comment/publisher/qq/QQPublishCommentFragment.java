package com.tencent.tkd.comment.publisher.qq;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.tkd.comment.adapt.PanelFrameLayout;
import com.tencent.tkd.comment.adapt.PanelInputDialogFragment;
import com.tencent.tkd.comment.publisher.qq.bridge.QQLifecycleBridge;
import com.tencent.tkd.comment.publisher.qq.bridge.QQLogBridge;
import com.tencent.tkd.comment.publisher.qq.bridge.QQPublishCommentBridge;
import com.tencent.tkd.comment.publisher.qq.bridge.QQReportBridge;
import com.tencent.tkd.comment.publisher.qq.bridge.QQSharedPreferenceBridge;
import com.tencent.tkd.comment.publisher.qq.bridge.QQUrlImageBridge;
import com.tencent.tkd.comment.publisher.qq.bridge.QQViewBridge;
import com.tencent.tkd.comment.publisher.qq.model.TkdCommentLinkData;
import com.tencent.tkd.comment.publisher.qq.model.TkdQQArgument;
import com.tencent.tkd.comment.publisher.qq.model.TkdQQArticleInfo;
import com.tencent.tkd.comment.publisher.qq.widget.TKDListenFocusEditText;
import com.tencent.tkd.comment.publisher.qq.widget.TkdCommentLinkView;
import com.tencent.tkd.comment.util.CommonUtil;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class QQPublishCommentFragment
  extends PanelInputDialogFragment
  implements View.OnClickListener
{
  private static final int OUTSIDE_COMMENT_EDIT_SRC_KANDIAN_FOLLOW_FEEDS = 1;
  protected static final int PANEL_EMOTION = 1;
  protected static final int PANEL_GIF = 2;
  protected static final int PANEL_NONE = 0;
  private static final int REPLY_COMMENT = 2;
  private static final String RIJ_SP_EDITOR_LAST_CHECK = "rij_sp_editor_last_check";
  private static final String TAG = "QQPublisherFragment";
  private static final int WRITE_COMMENT = 1;
  private QQPublishCommentFragment.BiuAndCommentMixUi biuAndCommentMixUi;
  private QQPublishCommentFragment.BiuUi biuUi;
  private int curPanel = 0;
  private boolean dismissOnDeliver;
  private QQPublishCommentFragment.EmotionUi emotionUi;
  private QQPublishCommentFragment.GifUi gifUi;
  private boolean isRecreate;
  private int lastState = 1;
  public QQLifecycleBridge lifecycleBridge = QQLifecycleBridge.EMPTY;
  private QQPublishCommentFragment.LinkUi linkUi;
  public QQLogBridge logBridge = QQLogBridge.EMPTY;
  private Activity mActivity;
  private boolean mInputOverlong;
  private int mMaxCharCount = 140;
  private String placeHolder;
  public QQPublishCommentBridge publishCommentBridge = QQPublishCommentBridge.EMPTY;
  private TkdQQArgument qqArgument;
  public QQReportBridge reportBridge = QQReportBridge.EMPTY;
  public QQSharedPreferenceBridge sharedPreferenceBridge = QQSharedPreferenceBridge.EMPTY;
  public QQUrlImageBridge urlImageBridge = QQUrlImageBridge.EMPTY;
  private ImageView vAt;
  private TextView vCharCountView;
  private Button vDeliverButton;
  private TKDListenFocusEditText vInputEdit;
  private PanelFrameLayout vPanelHolder;
  private ImageView vTopic;
  public QQViewBridge viewBridge = QQViewBridge.EMPTY;
  
  private void addViewToPanel(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    if (paramView.getParent() == null)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(CommonUtil.getScreenWidth(getActivity()), -1);
      if (paramBoolean)
      {
        this.vPanelHolder.addViewInLayout(paramView, 0, localLayoutParams, true);
        return;
      }
      this.vPanelHolder.addView(paramView, localLayoutParams);
    }
  }
  
  private void asyncPublicAccountReportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("toUin", paramString1);
    localBundle.putString("subAction", paramString2);
    localBundle.putString("actionName", paramString3);
    localBundle.putInt("fromType", 0);
    localBundle.putInt("result", 0);
    localBundle.putString("r2", paramString4);
    localBundle.putString("r3", paramString5);
    localBundle.putString("r4", paramString6);
    localBundle.putString("r5", paramString7);
    localBundle.putBoolean("shouldEncode", false);
    this.reportBridge.asyncReport(localBundle);
  }
  
  private boolean checkIsReadyToDeliver()
  {
    if (this.mInputOverlong)
    {
      this.logBridge.d("QQPublisherFragment", "onDeliver overlong!");
      showToast(getActivity().getString(R.string.d), 0, 1);
      return false;
    }
    if (!this.publishCommentBridge.isNetworkAvailable())
    {
      this.logBridge.d("QQPublisherFragment", "onDeliver network error!");
      showToast(getActivity().getString(R.string.e), 0, 1);
      return false;
    }
    return true;
  }
  
  private View getActivePanel()
  {
    int i = this.curPanel;
    if (i != 1)
    {
      if (i != 2) {
        return null;
      }
      return this.gifUi.getGifPanel();
    }
    return this.emotionUi.getEmotionPanel();
  }
  
  private String getCommentString()
  {
    return this.publishCommentBridge.getCommentString(this.vInputEdit.getText());
  }
  
  private JSONObject getFolderStatus(boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("folder_status", this.reportBridge.getFolderStatus());
        if (paramBoolean)
        {
          if (this.biuUi.isSelected)
          {
            String str1 = "0";
            localJSONObject.put("biu_comment", str1);
          }
        }
        else
        {
          localJSONObject.put("os", 1);
          localJSONObject.put("entry", this.reportBridge.getEntry());
          localJSONObject.put("scene", this.reportBridge.getScene());
          return localJSONObject;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return localJSONObject;
      }
      String str2 = "1";
    }
  }
  
  private String getFolderStatusString(boolean paramBoolean)
  {
    return getFolderStatus(paramBoolean).toString();
  }
  
  private String getToUin()
  {
    if (this.qqArgument.mArticleInfo != null) {
      return this.qqArgument.mArticleInfo.toUin;
    }
    return "";
  }
  
  private void initDefaultCommentAtFromArguments()
  {
    Object localObject = this.qqArgument.defaultTxt;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.vInputEdit.setText((CharSequence)localObject);
      this.vInputEdit.setSelection(((CharSequence)localObject).length());
      updateDeliverEnable();
      return;
    }
    localObject = this.vCharCountView;
    if (localObject != null) {
      ((TextView)localObject).setText(String.valueOf(this.mMaxCharCount));
    }
  }
  
  private void initPlaceHolderFromArguments()
  {
    this.placeHolder = this.qqArgument.placeHolder;
    QQLogBridge localQQLogBridge = this.logBridge;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initData | comment_placeholder : ");
    localStringBuilder.append(this.placeHolder);
    localQQLogBridge.d("QQPublisherFragment", localStringBuilder.toString());
    if (!TextUtils.isEmpty(this.placeHolder))
    {
      this.vInputEdit.setHint(this.placeHolder);
      return;
    }
    this.vInputEdit.setHint(this.mActivity.getString(R.string.c));
  }
  
  private void initView()
  {
    Dialog localDialog = getDialog();
    this.vPanelHolder = ((PanelFrameLayout)localDialog.findViewById(R.id.q));
    this.vCharCountView = ((TextView)localDialog.findViewById(R.id.j));
    this.vDeliverButton = ((Button)localDialog.findViewById(R.id.n));
    this.vDeliverButton.setOnClickListener(this);
    this.vInputEdit = ((TKDListenFocusEditText)localDialog.findViewById(R.id.w));
    this.vInputEdit.requestFocus();
    try
    {
      this.vInputEdit.setEditableFactory(this.viewBridge.getEditFactory());
      label93:
      this.vInputEdit.post(new QQPublishCommentFragment.1(this));
      init(localDialog.findViewById(R.id.B), this.vPanelHolder, this.vInputEdit);
      this.viewBridge.bindInput(this.vInputEdit);
      this.vTopic = ((ImageView)localDialog.findViewById(R.id.C));
      this.viewBridge.bindTopic(this.vTopic);
      this.vAt = ((ImageView)localDialog.findViewById(R.id.a));
      this.viewBridge.bindAt(getActivity(), this.vAt);
      this.vInputEdit.addTextChangedListener(new QQPublishCommentFragment.MyTextWatcher(this, null));
      this.emotionUi = new QQPublishCommentFragment.EmotionUi(this, localDialog);
      this.gifUi = new QQPublishCommentFragment.GifUi(this, localDialog);
      this.gifUi.initData();
      this.linkUi = new QQPublishCommentFragment.LinkUi(this, localDialog);
      this.linkUi.initData();
      this.biuAndCommentMixUi = new QQPublishCommentFragment.BiuAndCommentMixUi(this, localDialog);
      this.biuUi = new QQPublishCommentFragment.BiuUi(this, localDialog);
      this.biuUi.initData();
      this.gifUi.setOnGifChangeListener(this.biuUi);
      addViewToPanel(this.emotionUi.getEmotionPanel(), true);
      if (this.viewBridge.isNightMode()) {
        localDialog.findViewById(R.id.A).setVisibility(0);
      }
      if (this.biuAndCommentMixUi.initBiuAndCommentMix())
      {
        this.biuUi.hide();
        this.vDeliverButton.setVisibility(8);
      }
      this.viewBridge.bindCallback(new QQPublishCommentFragment.ViewCallback(this, null));
      return;
    }
    catch (Exception localException)
    {
      break label93;
    }
  }
  
  private void onDeliver()
  {
    if (!checkIsReadyToDeliver()) {
      return;
    }
    reportDeliver();
    this.viewBridge.onDeliever(packageDataInfo());
    this.dismissOnDeliver = true;
    dismissAllowingStateLoss();
  }
  
  private String packageDataInfo()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("comment", new String(Base64.encode(getCommentString().getBytes(), 0)));
      if (this.qqArgument.isNativeCommentComponet)
      {
        if (TextUtils.isEmpty(this.qqArgument.isSecondCommentReplyUin)) {
          str = "";
        } else {
          str = this.qqArgument.isSecondCommentReplyUin;
        }
        localJSONObject.put("replyUin", str);
        localJSONObject.put("isSecondReply", this.qqArgument.isSecondCommentReply);
        localJSONObject.put("commentId", this.qqArgument.commentId);
        localJSONObject.put("commentUin", this.qqArgument.mCommentAuthorUin);
      }
      this.linkUi.packageDataInfo(localJSONObject);
      this.biuUi.packageDataInfo(localJSONObject);
      String str = localJSONObject.toString();
      return str;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  private void publicAccountReportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("toUin", paramString1);
    localBundle.putString("subAction", paramString2);
    localBundle.putString("actionName", paramString3);
    localBundle.putInt("fromType", 0);
    localBundle.putInt("result", 0);
    localBundle.putString("r2", paramString4);
    localBundle.putString("r3", paramString5);
    localBundle.putString("r4", paramString6);
    localBundle.putString("r5", paramString7);
    localBundle.putBoolean("shouldEncode", false);
    this.reportBridge.report(localBundle);
  }
  
  private void reportCommentCancelEvent()
  {
    if (this.qqArgument.mClickCommentEditViewSrc == -1) {
      return;
    }
    String str;
    if (this.qqArgument.mClickCommentEditViewSrc == 1) {
      str = "0X80094C4";
    } else {
      str = "";
    }
    asyncPublicAccountReportClickEvent("", "", str, String.valueOf(this.qqArgument.mCommentType), "", "", getFolderStatusString(true));
  }
  
  private void reportDeliver()
  {
    boolean bool = TextUtils.isEmpty(getCommentString());
    int k = 0;
    int i;
    if (!bool) {
      i = 1;
    } else {
      i = 0;
    }
    int j = i;
    if (this.viewBridge.hasGif()) {
      j = i + 2;
    }
    String str;
    if (this.qqArgument.mClickCommentEditViewSrc == 1) {
      str = "0X80094A1";
    } else {
      str = "0X800844E";
    }
    JSONObject localJSONObject = getFolderStatus(true);
    for (;;)
    {
      try
      {
        localObject = QQPublishCommentFragment.LinkUi.access$400(this.linkUi).getData();
        if (localObject == null) {
          break label266;
        }
        if (!((List)localObject).isEmpty()) {
          break label261;
        }
      }
      catch (JSONException localJSONException)
      {
        Object localObject;
        StringBuilder localStringBuilder;
        localJSONException.printStackTrace();
      }
      localJSONObject.put("link", k);
      if (i == 0)
      {
        localStringBuilder = new StringBuilder();
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          localStringBuilder.append(((TkdCommentLinkData)((Iterator)localObject).next()).type);
          localStringBuilder.append(',');
          continue;
        }
        localJSONObject.put("link_type", localStringBuilder.deleteCharAt(localStringBuilder.length() - 1).toString());
      }
      this.reportBridge.fillR5OnDeliver(localJSONObject, this.vInputEdit.getText());
      publicAccountReportClickEvent(getToUin(), str, str, String.valueOf(this.qqArgument.mCommentType), String.valueOf(j), "", localJSONObject.toString());
      return;
      label261:
      i = 0;
      break label268;
      label266:
      i = 1;
      label268:
      if (i == 0) {
        k = 1;
      }
    }
  }
  
  private void reportOpenCommentComponent()
  {
    boolean bool = TextUtils.isEmpty(this.placeHolder);
    int k = 1;
    int i;
    if ((!bool) && (this.placeHolder.contains(getString(R.string.b)))) {
      i = 2;
    } else {
      i = 1;
    }
    for (;;)
    {
      String str;
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("folder_status", this.reportBridge.getFolderStatus());
        if (this.qqArgument.mArticleInfo != null) {
          ((JSONObject)localObject).put("consume_time", this.reportBridge.getConsumeTime());
        }
        ((JSONObject)localObject).put("os", 1);
        ((JSONObject)localObject).put("link_reply", this.qqArgument.linkReply);
        ((JSONObject)localObject).put("entry", this.reportBridge.getEntry());
        ((JSONObject)localObject).put("scene", this.reportBridge.getScene());
        if (!this.qqArgument.linkEnable) {
          break label288;
        }
        j = 1;
        ((JSONObject)localObject).put("link_entry", j);
        if (this.vTopic.getVisibility() != 0) {
          break label293;
        }
        j = 1;
        ((JSONObject)localObject).put("subject", j);
        if (this.vAt.getVisibility() != 0) {
          break label298;
        }
        j = k;
        ((JSONObject)localObject).put("at_entry", j);
        localObject = ((JSONObject)localObject).toString();
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        str = "";
      }
      publicAccountReportClickEvent(getToUin(), "0X800844A", "0X800844A", String.valueOf(i), String.valueOf(this.qqArgument.mSourceType), "", str);
      return;
      label288:
      int j = 0;
      continue;
      label293:
      j = 0;
      continue;
      label298:
      j = 0;
    }
  }
  
  private void showInputMethod()
  {
    this.vInputEdit.setWindowFocusChangeListener(new QQPublishCommentFragment.2(this));
  }
  
  private void showPanel(boolean paramBoolean)
  {
    View localView1 = getActivePanel();
    if (localView1 != null)
    {
      int j = this.vPanelHolder.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView2 = this.vPanelHolder.getChildAt(i);
        if (localView2 != localView1) {
          localView2.setVisibility(4);
        } else {
          localView2.setVisibility(0);
        }
        i += 1;
      }
      addViewToPanel(localView1, paramBoolean);
    }
  }
  
  private void updateDeliverEnable()
  {
    boolean bool2 = this.viewBridge.hasGif();
    boolean bool1 = true;
    if ((!bool2) && (TextUtils.isEmpty(getCommentString()))) {
      bool1 = false;
    }
    this.vDeliverButton.setEnabled(bool1);
    this.biuAndCommentMixUi.onUpdateDeliverEnable(bool1);
  }
  
  protected void beforeStateChange(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 2)
    {
      this.curPanel = 0;
    }
    else
    {
      boolean bool = true;
      if (paramInt1 != 1) {
        bool = false;
      }
      showPanel(bool);
    }
    this.emotionUi.onStatusChanged();
    this.gifUi.onStatusChanged();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (paramBundle != null)
    {
      this.isRecreate = true;
      getActivity().finish();
      return;
    }
    this.qqArgument = this.publishCommentBridge.getArgument();
    initView();
    this.mMaxCharCount = this.qqArgument.maxCharCount;
    initDefaultCommentAtFromArguments();
    initPlaceHolderFromArguments();
    reportOpenCommentComponent();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.lifecycleBridge.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.vDeliverButton) {
      onDeliver();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mActivity = getActivity();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.b, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.isRecreate) {
      return;
    }
    this.linkUi.onDestroy();
    if (!this.dismissOnDeliver) {
      reportCommentCancelEvent();
    }
    this.lifecycleBridge.onDestroy(this.dismissOnDeliver ^ true);
  }
  
  public void onPause()
  {
    super.onPause();
    this.lastState = getState();
    this.lifecycleBridge.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.lifecycleBridge.onResume();
    if (this.lastState == 1) {
      showInputMethod();
    }
  }
  
  public void showToast(String paramString, int paramInt)
  {
    showToast(paramString, paramInt, 0);
  }
  
  public void showToast(String paramString, int paramInt1, int paramInt2)
  {
    this.publishCommentBridge.showToast(paramString, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.QQPublishCommentFragment
 * JD-Core Version:    0.7.0.1
 */