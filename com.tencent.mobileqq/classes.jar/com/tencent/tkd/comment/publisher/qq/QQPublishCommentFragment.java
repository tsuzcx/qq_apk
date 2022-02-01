package com.tencent.tkd.comment.publisher.qq;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.tkd.comment.adapt.PanelFrameLayout;
import com.tencent.tkd.comment.adapt.PanelInputDialogFragment;
import com.tencent.tkd.comment.publisher.qq.bridge.QQLifecycleBridge;
import com.tencent.tkd.comment.publisher.qq.bridge.QQPublishCommentBridge;
import com.tencent.tkd.comment.publisher.qq.model.TkdCommentLinkData;
import com.tencent.tkd.comment.publisher.qq.model.TkdQQArgument;
import com.tencent.tkd.comment.publisher.qq.model.TkdQQArticleInfo;
import com.tencent.tkd.comment.publisher.qq.util.TkdQQLog;
import com.tencent.tkd.comment.publisher.qq.util.TkdQQReport;
import com.tencent.tkd.comment.publisher.qq.util.TkdQQToast;
import com.tencent.tkd.comment.publisher.qq.util.TkdQQView;
import com.tencent.tkd.comment.publisher.qq.widget.TkdCommentLinkView;
import com.tencent.tkd.comment.util.CommonUtil;
import java.util.HashMap;
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
  private static HashMap<String, String> draftMap = new HashMap();
  private QQPublishCommentFragment.BiuAndCommentMixUi biuAndCommentMixUi;
  private QQPublishCommentFragment.BiuUi biuUi;
  private int curPanel = 0;
  private boolean dismissOnDeliver;
  private QQPublishCommentFragment.EmotionUi emotionUi;
  private QQPublishCommentFragment.GifUi gifUi;
  private boolean isRecreate;
  private int lastState = 1;
  private QQPublishCommentFragment.LinkUi linkUi;
  private Activity mActivity;
  private boolean mInputOverlong;
  private int mMaxCharCount = 140;
  private String placeHolder;
  private TkdQQArgument qqArgument;
  private TextView vCharCountView;
  private Button vDeliverButton;
  private EditText vInputEdit;
  private PanelFrameLayout vPanelHolder;
  private ImageView vTopic;
  
  private void addCommentDraft()
  {
    String str1 = getDraftId();
    String str2 = getCommentString();
    if (str2 != null) {
      draftMap.put(str1, str2);
    }
  }
  
  private void addViewToPanel(View paramView, boolean paramBoolean)
  {
    FrameLayout.LayoutParams localLayoutParams;
    if (paramView.getParent() == null)
    {
      localLayoutParams = new FrameLayout.LayoutParams(CommonUtil.getScreenWidth(getActivity()), -1);
      if (paramBoolean) {
        this.vPanelHolder.addViewInLayout(paramView, 0, localLayoutParams, true);
      }
    }
    else
    {
      return;
    }
    this.vPanelHolder.addView(paramView, localLayoutParams);
  }
  
  private boolean checkIsReadyToDeliver()
  {
    if (this.mInputOverlong)
    {
      TkdQQLog.d("QQPublisherFragment", "onDeliver overlong!");
      TkdQQToast.show(getActivity().getString(2131719930), 0, 1);
      return false;
    }
    if (!QQPublishCommentManager.getInstance().getPublisherBridge().isNetworkAvailable())
    {
      TkdQQLog.d("QQPublisherFragment", "onDeliver network error!");
      TkdQQToast.show(getActivity().getString(2131719931), 0, 1);
      return false;
    }
    return true;
  }
  
  private View getActivePanel()
  {
    switch (this.curPanel)
    {
    default: 
      return null;
    case 1: 
      return this.emotionUi.getEmotionPanel();
    }
    return this.gifUi.getGifPanel();
  }
  
  private String getCommentString()
  {
    if (QQPublishCommentManager.getInstance().getPublisherBridge() != null) {
      return QQPublishCommentManager.getInstance().getPublisherBridge().getCommentString(this.vInputEdit.getText());
    }
    return "";
  }
  
  private String getDraftId()
  {
    try
    {
      Object localObject = new JSONObject();
      if (!TextUtils.isEmpty(this.qqArgument.innerUniqueID)) {
        ((JSONObject)localObject).put("innerUniqueID", this.qqArgument.innerUniqueID);
      }
      if (!TextUtils.isEmpty(this.qqArgument.commentId)) {
        ((JSONObject)localObject).put("commentId", this.qqArgument.commentId);
      }
      if (!TextUtils.isEmpty(this.qqArgument.firstCommentId)) {
        ((JSONObject)localObject).put("firstCommentId", this.qqArgument.firstCommentId);
      }
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  private JSONObject getFolderStatus(boolean paramBoolean)
  {
    localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("folder_status", TkdQQReport.getFolderStatus());
      if (paramBoolean) {
        if (!this.biuUi.isSelected) {
          break label79;
        }
      }
      label79:
      for (String str = "0";; str = "1")
      {
        localJSONObject.put("biu_comment", str);
        localJSONObject.put("os", 1);
        localJSONObject.put("entry", TkdQQReport.getEntry());
        localJSONObject.put("scene", TkdQQReport.getScene());
        return localJSONObject;
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
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
  
  private void initDefaultComment(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = TkdQQView.getEmotionText(paramString);
      TkdQQLog.d("QQPublisherFragment", "initData | default_comment : " + paramString);
      this.vInputEdit.setText(paramString);
      this.vInputEdit.setSelection(paramString.length());
      updateDeliverEnable();
    }
    while (this.vCharCountView == null) {
      return;
    }
    this.vCharCountView.setText(String.valueOf(this.mMaxCharCount));
  }
  
  private void initDefaultCommentAtFromArguments()
  {
    initDefaultComment(this.qqArgument.defaultTxt);
  }
  
  private void initDefaultCommentFromDraft()
  {
    String str2 = this.qqArgument.recreateDraft;
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = getDraftId();
      str1 = (String)draftMap.get(str1);
    }
    initDefaultComment(str1);
  }
  
  private void initDefaultInput()
  {
    if ((isCommentArticle()) && (!TextUtils.isEmpty(this.qqArgument.defaultInput)))
    {
      TkdQQLog.d("QQPublisherFragment", "initData | comment_default_input : " + this.qqArgument.defaultInput);
      this.vInputEdit.setHint(this.qqArgument.defaultInput);
    }
  }
  
  private void initPlaceHolderFromArguments()
  {
    this.placeHolder = this.qqArgument.placeHolder;
    TkdQQLog.d("QQPublisherFragment", "initData | comment_placeholder : " + this.placeHolder);
    if (!TextUtils.isEmpty(this.placeHolder))
    {
      this.vInputEdit.setHint(this.placeHolder);
      return;
    }
    this.vInputEdit.setHint(this.mActivity.getString(2131719926));
  }
  
  private void initView()
  {
    Dialog localDialog = getDialog();
    this.vPanelHolder = ((PanelFrameLayout)localDialog.findViewById(2131367912));
    this.vCharCountView = ((TextView)localDialog.findViewById(2131364581));
    this.vDeliverButton = ((Button)localDialog.findViewById(2131365668));
    this.vDeliverButton.setOnClickListener(this);
    this.vInputEdit = ((EditText)localDialog.findViewById(2131369141));
    this.vInputEdit.requestFocus();
    try
    {
      this.vInputEdit.setEditableFactory(TkdQQView.getEditFactory());
      label87:
      this.vInputEdit.addTextChangedListener(new QQPublishCommentFragment.MyTextWatcher(this, null));
      this.vInputEdit.post(new QQPublishCommentFragment.1(this));
      init(localDialog.findViewById(2131377356), this.vPanelHolder, this.vInputEdit);
      TkdQQView.bindInput(this.vInputEdit);
      this.vTopic = ((ImageView)localDialog.findViewById(2131379696));
      TkdQQView.bindTopic(this.vTopic);
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
      if (TkdQQView.isNightMode()) {
        localDialog.findViewById(2131372297).setVisibility(0);
      }
      if (this.biuAndCommentMixUi.initBiuAndCommentMix())
      {
        this.biuUi.hide();
        this.vDeliverButton.setVisibility(8);
      }
      TkdQQView.bindCallback(new QQPublishCommentFragment.ViewCallback(this, null));
      return;
    }
    catch (Exception localException)
    {
      break label87;
    }
  }
  
  private boolean isCommentArticle()
  {
    return TextUtils.isEmpty(this.qqArgument.commentId);
  }
  
  private void onDeliver()
  {
    if (!checkIsReadyToDeliver()) {
      return;
    }
    reportDeliver();
    TkdQQView.onDeliever(packageDataInfo());
    this.dismissOnDeliver = true;
    dismissAllowingStateLoss();
  }
  
  private String packageDataInfo()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("comment", new String(Base64.encode(getCommentString().getBytes(), 0)));
      if (this.qqArgument.isNativeCommentComponet) {
        if (!TextUtils.isEmpty(this.qqArgument.isSecondCommentReplyUin)) {
          break label136;
        }
      }
      label136:
      for (String str = "";; str = this.qqArgument.isSecondCommentReplyUin)
      {
        localJSONObject.put("replyUin", str);
        localJSONObject.put("isSecondReply", this.qqArgument.isSecondCommentReply);
        localJSONObject.put("commentId", this.qqArgument.commentId);
        localJSONObject.put("commentUin", this.qqArgument.mCommentAuthorUin);
        this.linkUi.packageDataInfo(localJSONObject);
        this.biuUi.packageDataInfo(localJSONObject);
        return localJSONObject.toString();
      }
      return null;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void removeCommentDraft()
  {
    String str = getDraftId();
    draftMap.remove(str);
  }
  
  private void reportCommentCancelEvent()
  {
    if (this.qqArgument.mClickCommentEditViewSrc == -1) {
      return;
    }
    String str = "";
    if (this.qqArgument.mClickCommentEditViewSrc == 1) {
      str = "0X80094C4";
    }
    TkdQQReport.asyncPublicAccountReportClickEvent("", "", str, String.valueOf(this.qqArgument.mCommentType), "", "", getFolderStatusString(true));
  }
  
  private void reportDeliver()
  {
    int k = 0;
    int i;
    label24:
    String str;
    JSONObject localJSONObject;
    if (!TextUtils.isEmpty(getCommentString()))
    {
      i = 1;
      if (TkdQQView.hasGif())
      {
        i += 2;
        str = "0X800844E";
        if (this.qqArgument.mClickCommentEditViewSrc == 1) {
          str = "0X80094A1";
        }
        localJSONObject = getFolderStatus(true);
      }
    }
    for (;;)
    {
      try
      {
        localObject = QQPublishCommentFragment.LinkUi.access$400(this.linkUi).getData();
        if (localObject == null) {
          break label237;
        }
        if (!((List)localObject).isEmpty()) {
          break label192;
        }
      }
      catch (JSONException localJSONException)
      {
        Object localObject;
        label82:
        StringBuilder localStringBuilder;
        localJSONException.printStackTrace();
      }
      localJSONObject.put("link", k);
      if (j == 0)
      {
        localStringBuilder = new StringBuilder();
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          localStringBuilder.append(((TkdCommentLinkData)((Iterator)localObject).next()).type).append(',');
          continue;
        }
      }
      else
      {
        label158:
        TkdQQReport.publicAccountReportClickEvent(getToUin(), str, str, String.valueOf(this.qqArgument.mCommentType), String.valueOf(i), "", localJSONObject.toString());
        return;
      }
      label192:
      label237:
      for (int j = 0; j == 0; j = 1)
      {
        k = 1;
        break label82;
        localJSONObject.put("link_type", localJSONException.deleteCharAt(localJSONException.length() - 1).toString());
        break label158;
        break label24;
        i = 0;
        break;
      }
    }
  }
  
  private void reportOpenCommentComponent()
  {
    int k = 1;
    if ((!TextUtils.isEmpty(this.placeHolder)) && (this.placeHolder.contains(getString(2131719925)))) {}
    for (int i = 2;; i = 1)
    {
      Object localObject1 = "";
      for (;;)
      {
        try
        {
          Object localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("folder_status", TkdQQReport.getFolderStatus());
          if (this.qqArgument.mArticleInfo != null) {
            ((JSONObject)localObject2).put("consume_time", TkdQQReport.getConsumeTime());
          }
          ((JSONObject)localObject2).put("os", 1);
          ((JSONObject)localObject2).put("link_reply", this.qqArgument.linkReply);
          ((JSONObject)localObject2).put("entry", TkdQQReport.getEntry());
          ((JSONObject)localObject2).put("scene", TkdQQReport.getScene());
          if (!this.qqArgument.linkEnable) {
            continue;
          }
          j = 1;
          ((JSONObject)localObject2).put("link_entry", j);
          if (this.vTopic.getVisibility() != 0) {
            continue;
          }
          j = k;
          ((JSONObject)localObject2).put("subject", j);
          localObject2 = ((JSONObject)localObject2).toString();
          localObject1 = localObject2;
        }
        catch (JSONException localJSONException)
        {
          int j;
          localJSONException.printStackTrace();
          continue;
        }
        TkdQQReport.publicAccountReportClickEvent(getToUin(), "0X800844A", "0X800844A", String.valueOf(i), String.valueOf(this.qqArgument.mSourceType), "", (String)localObject1);
        return;
        j = 0;
        continue;
        j = 0;
      }
    }
  }
  
  private void showPanel(boolean paramBoolean)
  {
    View localView1 = getActivePanel();
    if (localView1 != null)
    {
      int j = this.vPanelHolder.getChildCount();
      int i = 0;
      if (i < j)
      {
        View localView2 = this.vPanelHolder.getChildAt(i);
        if (localView2 != localView1) {
          localView2.setVisibility(4);
        }
        for (;;)
        {
          i += 1;
          break;
          localView2.setVisibility(0);
        }
      }
      addViewToPanel(localView1, paramBoolean);
    }
  }
  
  private void updateDeliverEnable()
  {
    boolean bool = true;
    if (TkdQQView.hasGif()) {}
    for (;;)
    {
      this.vDeliverButton.setEnabled(bool);
      this.biuAndCommentMixUi.onUpdateDeliverEnable(bool);
      return;
      if (TextUtils.isEmpty(getCommentString())) {
        bool = false;
      }
    }
  }
  
  public void beforeStateChange(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (paramInt2 != 2)
    {
      this.curPanel = 0;
      this.emotionUi.onStatusChanged();
      this.gifUi.onStatusChanged();
      return;
    }
    if (paramInt1 == 1) {}
    for (;;)
    {
      showPanel(bool);
      break;
      bool = false;
    }
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
    this.qqArgument = QQPublishCommentManager.getInstance().getPublisherBridge().getArgument();
    initView();
    this.mMaxCharCount = this.qqArgument.maxCharCount;
    initDefaultCommentAtFromArguments();
    initPlaceHolderFromArguments();
    initDefaultCommentFromDraft();
    initDefaultInput();
    reportOpenCommentComponent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.vDeliverButton) {
      onDeliver();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mActivity = getActivity();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131563106, paramViewGroup, false);
    FragmentCollector.onFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.isRecreate) {}
    do
    {
      return;
      this.linkUi.onDestroy();
    } while (QQPublishCommentManager.getInstance().isBridgeNotAvailable());
    QQLifecycleBridge localQQLifecycleBridge;
    if (!this.dismissOnDeliver)
    {
      reportCommentCancelEvent();
      addCommentDraft();
      localQQLifecycleBridge = QQPublishCommentManager.getInstance().getLifecycleBridge();
      if (this.dismissOnDeliver) {
        break label80;
      }
    }
    label80:
    for (boolean bool = true;; bool = false)
    {
      localQQLifecycleBridge.onDestroy(bool);
      QQPublishCommentManager.getInstance().reset();
      return;
      removeCommentDraft();
      break;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (QQPublishCommentManager.getInstance().isBridgeNotAvailable()) {
      return;
    }
    this.lastState = getState();
    QQPublishCommentManager.getInstance().getLifecycleBridge().onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (QQPublishCommentManager.getInstance().isBridgeNotAvailable()) {
      getActivity().finish();
    }
    do
    {
      return;
      QQPublishCommentManager.getInstance().getLifecycleBridge().onResume();
    } while (this.lastState != 1);
    this.vInputEdit.postDelayed(new QQPublishCommentFragment.2(this), 150L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.QQPublishCommentFragment
 * JD-Core Version:    0.7.0.1
 */