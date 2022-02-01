package com.tencent.tkd.comment.publisher.qq;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.tencent.tkd.comment.publisher.qq.model.TkdQQArgument;
import com.tencent.tkd.comment.publisher.qq.widget.TKDListenFocusEditText;
import com.tencent.tkd.comment.publisher.qq.widget.TkdCommentLinkView;
import com.tencent.tkd.comment.util.CommonUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class QQPublishCommentFragment
  extends PanelInputDialogFragment
  implements View.OnClickListener
{
  private static final int PANEL_EMOTION = 1;
  private static final int PANEL_GIF = 2;
  private static final int PANEL_NONE = 0;
  private static final String TAG = "QQPublisherFragment";
  private int curPanel = 0;
  private boolean dismissOnDeliver;
  private QQPublishCommentFragment.EmotionUi emotionUi;
  private boolean firstOpen = true;
  private QQPublishCommentFragment.GifUi gifUi;
  private boolean isRecreate;
  private int lastState = 1;
  public QQLifecycleBridge lifecycleBridge = QQLifecycleBridge.EMPTY;
  private QQPublishCommentFragment.LinkUi linkUi;
  public QQLogBridge logBridge = QQLogBridge.EMPTY;
  private Activity mActivity;
  private boolean mInputOverlong;
  private int mMaxCharCount = 140;
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
  
  private void checkFirstAction()
  {
    if (!this.firstOpen) {
      return;
    }
    this.firstOpen = false;
    int i = this.qqArgument.firstAction;
    if (i != 1)
    {
      if (i != 2)
      {
        this.lastState = 1;
        return;
      }
      this.lastState = 0;
      performClickAt();
      return;
    }
    this.lastState = 0;
    this.emotionUi.switchPanel();
  }
  
  private boolean checkIsReadyToDeliver()
  {
    if (this.mInputOverlong)
    {
      this.logBridge.d("QQPublisherFragment", "onDeliver overlong!");
      showToast(getActivity().getString(R.string.b), 0, 1);
      return false;
    }
    if (!this.publishCommentBridge.isNetworkAvailable())
    {
      this.logBridge.d("QQPublisherFragment", "onDeliver network error!");
      showToast(getActivity().getString(R.string.c), 0, 1);
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
    return this.viewBridge.getCommentString(this.vInputEdit.getText());
  }
  
  private void initAt(Dialog paramDialog)
  {
    this.vAt = ((ImageView)paramDialog.findViewById(R.id.a));
    if (this.qqArgument.forceHideAt)
    {
      this.vAt.setVisibility(8);
      return;
    }
    this.viewBridge.bindAt(getActivity(), this.vAt);
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
    String str = this.qqArgument.placeHolder;
    QQLogBridge localQQLogBridge = this.logBridge;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initData | comment_placeholder : ");
    localStringBuilder.append(str);
    localQQLogBridge.d("QQPublisherFragment", localStringBuilder.toString());
    if (!TextUtils.isEmpty(str))
    {
      this.vInputEdit.setHint(str);
      return;
    }
    this.vInputEdit.setHint(this.mActivity.getString(R.string.a));
  }
  
  private void initTopic(Dialog paramDialog)
  {
    this.vTopic = ((ImageView)paramDialog.findViewById(R.id.t));
    if (this.qqArgument.forceHideTopic)
    {
      this.vTopic.setVisibility(8);
      return;
    }
    this.viewBridge.bindTopic(this.vTopic);
  }
  
  private void initView()
  {
    Dialog localDialog = getDialog();
    this.vPanelHolder = ((PanelFrameLayout)localDialog.findViewById(R.id.h));
    this.vCharCountView = ((TextView)localDialog.findViewById(R.id.b));
    this.vDeliverButton = ((Button)localDialog.findViewById(R.id.e));
    this.vDeliverButton.setOnClickListener(this);
    this.vInputEdit = ((TKDListenFocusEditText)localDialog.findViewById(R.id.n));
    try
    {
      this.vInputEdit.setEditableFactory(this.viewBridge.getEditFactory());
    }
    catch (Exception localException)
    {
      this.logBridge.d("QQPublisherFragment", localException.getMessage());
    }
    init(localDialog.findViewById(R.id.s), this.vPanelHolder, this.vInputEdit);
    this.viewBridge.bindInput(this.vInputEdit);
    initTopic(localDialog);
    initAt(localDialog);
    this.vInputEdit.addTextChangedListener(new QQPublishCommentFragment.MyTextWatcher(this, null));
    this.emotionUi = new QQPublishCommentFragment.EmotionUi(this, localDialog);
    this.gifUi = new QQPublishCommentFragment.GifUi(this, localDialog);
    this.gifUi.initData();
    this.linkUi = new QQPublishCommentFragment.LinkUi(this, localDialog);
    this.linkUi.initData();
    addViewToPanel(this.emotionUi.getEmotionPanel(), true);
    if (this.viewBridge.isNightMode()) {
      localDialog.findViewById(R.id.r).setVisibility(0);
    }
    this.viewBridge.bindCallback(new QQPublishCommentFragment.ViewCallback(this, null));
  }
  
  private void onDeliver()
  {
    if (!checkIsReadyToDeliver()) {
      return;
    }
    this.reportBridge.reportDeliver(this.vInputEdit.getText(), QQPublishCommentFragment.LinkUi.access$400(this.linkUi).getData());
    this.viewBridge.onDeliever(packageDataInfo());
    this.dismissOnDeliver = true;
    dismissAllowingStateLoss();
  }
  
  private String packageDataInfo()
  {
    Object localObject = new JSONObject();
    try
    {
      this.viewBridge.packageDataInfo((JSONObject)localObject, this.vInputEdit.getText());
      this.linkUi.packageDataInfo((JSONObject)localObject);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  private void performClickAt()
  {
    this.vAt.post(new QQPublishCommentFragment.1(this));
  }
  
  private void showInputMethod()
  {
    this.vInputEdit.requestFocus();
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
  
  private void showToast(String paramString, int paramInt1, int paramInt2)
  {
    this.publishCommentBridge.showToast(paramString, paramInt1, paramInt2);
  }
  
  private void updateDeliverEnable()
  {
    boolean bool2 = this.viewBridge.hasGif();
    boolean bool1 = true;
    if ((!bool2) && (TextUtils.isEmpty(getCommentString()))) {
      bool1 = false;
    }
    this.vDeliverButton.setEnabled(bool1);
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
    boolean bool2 = true;
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
    paramBundle = this.reportBridge;
    boolean bool1;
    if (this.vTopic.getVisibility() == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (this.vAt.getVisibility() != 0) {
      bool2 = false;
    }
    paramBundle.reportOpenCommentComponent(bool1, bool2);
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
      this.reportBridge.reportCommentCancelEvent();
    }
    this.lifecycleBridge.onDestroy(this.dismissOnDeliver ^ true);
  }
  
  public void onPause()
  {
    super.onPause();
    this.lastState = getState();
    this.lifecycleBridge.onPause();
    if (this.lastState == 0) {
      showInputMethod();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.lifecycleBridge.onResume();
    checkFirstAction();
    if (this.lastState == 1) {
      showInputMethod();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.QQPublishCommentFragment
 * JD-Core Version:    0.7.0.1
 */