package com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl;

import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.Editable.Factory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.view.widget.text.DeleteAsAWholeWatcher;
import com.tencent.mobileqq.kandian.biz.comment.base.listener.OnDeliverListener;
import com.tencent.mobileqq.kandian.biz.comment.base.model.CommentArgumentModel;
import com.tencent.mobileqq.kandian.biz.comment.emotion.util.RIJEmotionTextWatcher;
import com.tencent.mobileqq.kandian.biz.comment.emotion.util.RIJEmotionUtil;
import com.tencent.mobileqq.kandian.biz.comment.helper.DraftDataUtil;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.RIJCommentRptDataUtil;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.at.RIJCommentAtUi;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.topic.RIJCommentTopicUi;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.tkd.comment.publisher.qq.bridge.QQLifecycleBridge;
import com.tencent.tkd.comment.publisher.qq.bridge.QQReportBridge;
import com.tencent.tkd.comment.publisher.qq.bridge.QQViewBridge;
import com.tencent.tkd.comment.publisher.qq.util.QQViewCallback;
import com.tencent.tkd.comment.publisher.qq.util.selectionchange.ISelectionChangeObservable;
import com.tencent.util.InputMethodUtil;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class QQViewBridgeImpl
  implements QQLifecycleBridge, QQViewBridge
{
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private final QQViewBridgeImpl.EmotionUi jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseBridgeimplQQViewBridgeImpl$EmotionUi;
  private final QQViewBridgeImpl.GifUi jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseBridgeimplQQViewBridgeImpl$GifUi;
  private final QQViewBridgeImpl.LinkUi jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseBridgeimplQQViewBridgeImpl$LinkUi;
  private OnDeliverListener jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseListenerOnDeliverListener;
  private final CommentArgumentModel jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseModelCommentArgumentModel;
  private RIJCommentAtUi jdField_a_of_type_ComTencentMobileqqKandianBizCommentRptdataAtRIJCommentAtUi;
  private RIJCommentTopicUi jdField_a_of_type_ComTencentMobileqqKandianBizCommentRptdataTopicRIJCommentTopicUi;
  private QQReportBridge jdField_a_of_type_ComTencentTkdCommentPublisherQqBridgeQQReportBridge;
  private QQViewCallback jdField_a_of_type_ComTencentTkdCommentPublisherQqUtilQQViewCallback;
  
  public QQViewBridgeImpl(CommentArgumentModel paramCommentArgumentModel)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseModelCommentArgumentModel = paramCommentArgumentModel;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseBridgeimplQQViewBridgeImpl$LinkUi = new QQViewBridgeImpl.LinkUi(this, null);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseBridgeimplQQViewBridgeImpl$EmotionUi = new QQViewBridgeImpl.EmotionUi(this, null);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseBridgeimplQQViewBridgeImpl$GifUi = new QQViewBridgeImpl.GifUi(this, null);
  }
  
  private String a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseBridgeimplQQViewBridgeImpl$GifUi.a(paramString);
      RIJCommentRptDataUtil.a(paramString, this.jdField_a_of_type_AndroidWidgetEditText.getText());
      paramString = paramString.toString();
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void a(boolean paramBoolean)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseModelCommentArgumentModel.a();
    if (paramBoolean)
    {
      DraftDataUtil.a(str, this.jdField_a_of_type_AndroidWidgetEditText.getEditableText());
      return;
    }
    DraftDataUtil.a(str);
  }
  
  public QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public void a(OnDeliverListener paramOnDeliverListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseListenerOnDeliverListener = paramOnDeliverListener;
  }
  
  public void a(QQReportBridge paramQQReportBridge)
  {
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqBridgeQQReportBridge = paramQQReportBridge;
  }
  
  public void bindAt(Activity paramActivity, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentRptdataAtRIJCommentAtUi = new RIJCommentAtUi(paramActivity, paramView, this.jdField_a_of_type_AndroidWidgetEditText, new QQViewBridgeImpl.FuncReportRunnable(this, "0X800BAC1", null));
  }
  
  public void bindCallback(QQViewCallback paramQQViewCallback)
  {
    this.jdField_a_of_type_ComTencentTkdCommentPublisherQqUtilQQViewCallback = paramQQViewCallback;
  }
  
  public void bindInput(EditText paramEditText)
  {
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
    paramEditText.addTextChangedListener(new DeleteAsAWholeWatcher());
    paramEditText.addTextChangedListener(new RIJEmotionTextWatcher(paramEditText));
    if ((paramEditText instanceof ISelectionChangeObservable)) {
      ((ISelectionChangeObservable)paramEditText).a(new QQViewBridgeImpl.EditTextSelectionChangeObserver(null));
    }
  }
  
  public void bindTopic(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentRptdataTopicRIJCommentTopicUi = new RIJCommentTopicUi(paramView, this.jdField_a_of_type_AndroidWidgetEditText, new QQViewBridgeImpl.FuncReportRunnable(this, "0X800B9E0", null));
  }
  
  public void deleteGif()
  {
    QQViewBridgeImpl.GifUi.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseBridgeimplQQViewBridgeImpl$GifUi);
  }
  
  public Editable.Factory getEditFactory()
  {
    return new QQViewBridgeImpl.1(this);
  }
  
  public View getEmotionPanel(Activity paramActivity)
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseBridgeimplQQViewBridgeImpl$EmotionUi.a(paramActivity);
  }
  
  public View getGifPanel(Activity paramActivity)
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseBridgeimplQQViewBridgeImpl$GifUi.a(paramActivity);
  }
  
  public int getTextLength(Editable paramEditable)
  {
    return RIJEmotionUtil.a(paramEditable);
  }
  
  public boolean hasGif()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseBridgeimplQQViewBridgeImpl$GifUi.a != null;
  }
  
  public boolean isNightMode()
  {
    return ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    RIJCommentAtUi localRIJCommentAtUi = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentRptdataAtRIJCommentAtUi;
    if (localRIJCommentAtUi != null) {
      localRIJCommentAtUi.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onDeleteLink()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseBridgeimplQQViewBridgeImpl$LinkUi.c();
  }
  
  public void onDeliever(String paramString)
  {
    OnDeliverListener localOnDeliverListener = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseListenerOnDeliverListener;
    if (localOnDeliverListener != null) {
      localOnDeliverListener.b(a(paramString));
    }
  }
  
  public void onDelieverBiu(String paramString)
  {
    OnDeliverListener localOnDeliverListener = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseListenerOnDeliverListener;
    if (localOnDeliverListener != null) {
      localOnDeliverListener.c(a(paramString));
    }
  }
  
  public void onDestroy(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseBridgeimplQQViewBridgeImpl$LinkUi.a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseBridgeimplQQViewBridgeImpl$EmotionUi.a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseBridgeimplQQViewBridgeImpl$GifUi.a();
    RIJCommentTopicUi localRIJCommentTopicUi = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentRptdataTopicRIJCommentTopicUi;
    if (localRIJCommentTopicUi != null)
    {
      localRIJCommentTopicUi.a();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentRptdataTopicRIJCommentTopicUi = null;
    }
    a(paramBoolean);
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void openLink(ViewGroup paramViewGroup)
  {
    InputMethodUtil.b(this.jdField_a_of_type_AndroidWidgetEditText);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseBridgeimplQQViewBridgeImpl$LinkUi.a(paramViewGroup);
    QQViewBridgeImpl.LinkUi.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseBridgeimplQQViewBridgeImpl$LinkUi, paramViewGroup.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQViewBridgeImpl
 * JD-Core Version:    0.7.0.1
 */