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
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.comment.base.listener.OnDeliverListener;
import com.tencent.mobileqq.kandian.biz.comment.base.model.CommentArgumentModel;
import com.tencent.mobileqq.kandian.biz.comment.base.model.IPublishScene;
import com.tencent.mobileqq.kandian.biz.comment.emotion.util.RIJEmotionTextWatcher;
import com.tencent.mobileqq.kandian.biz.comment.emotion.util.RIJEmotionUtil;
import com.tencent.mobileqq.kandian.biz.comment.helper.DraftDataUtil;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.RIJCommentRptDataUtil;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.at.RIJCommentAtUi;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.topic.RIJCommentTopicUi;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
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
  private final CommentArgumentModel a;
  private EditText b;
  private final QQViewBridgeImpl.LinkUi c;
  private final QQViewBridgeImpl.EmotionUi d;
  private final QQViewBridgeImpl.GifUi e;
  private QQViewCallback f;
  private OnDeliverListener g;
  private RIJCommentTopicUi h;
  private RIJCommentAtUi i;
  private QQReportBridge j;
  
  public QQViewBridgeImpl(CommentArgumentModel paramCommentArgumentModel)
  {
    this.a = paramCommentArgumentModel;
    this.c = new QQViewBridgeImpl.LinkUi(this, null);
    this.d = new QQViewBridgeImpl.EmotionUi(this, null);
    this.e = new QQViewBridgeImpl.GifUi(this, null);
  }
  
  public static String a(CharSequence paramCharSequence)
  {
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0)) {
      paramCharSequence = ReadInJoyCommentUtils.a(paramCharSequence.toString(), true);
    } else {
      paramCharSequence = "";
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCommentString result=");
      localStringBuilder.append(paramCharSequence);
      QLog.d("QQViewBridgeImpl", 2, localStringBuilder.toString());
    }
    return paramCharSequence;
  }
  
  private String a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.e.a(paramString);
      RIJCommentRptDataUtil.a(paramString, this.b.getText());
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
    String str = this.a.d.c();
    if (paramBoolean)
    {
      DraftDataUtil.a(str, this.b.getEditableText());
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
    this.g = paramOnDeliverListener;
  }
  
  public void a(QQReportBridge paramQQReportBridge)
  {
    this.j = paramQQReportBridge;
  }
  
  public void bindAt(Activity paramActivity, View paramView)
  {
    this.i = new RIJCommentAtUi(paramActivity, paramView, this.b, new QQViewBridgeImpl.FuncReportRunnable(this, "0X800BAC1", null));
  }
  
  public void bindCallback(QQViewCallback paramQQViewCallback)
  {
    this.f = paramQQViewCallback;
  }
  
  public void bindInput(EditText paramEditText)
  {
    this.b = paramEditText;
    paramEditText.addTextChangedListener(new DeleteAsAWholeWatcher());
    paramEditText.addTextChangedListener(new RIJEmotionTextWatcher(paramEditText));
    if ((paramEditText instanceof ISelectionChangeObservable)) {
      ((ISelectionChangeObservable)paramEditText).a(new QQViewBridgeImpl.EditTextSelectionChangeObserver(null));
    }
  }
  
  public void bindTopic(View paramView)
  {
    this.h = new RIJCommentTopicUi(paramView, this.b, new QQViewBridgeImpl.FuncReportRunnable(this, "0X800B9E0", null));
  }
  
  public void deleteGif()
  {
    QQViewBridgeImpl.GifUi.a(this.e);
  }
  
  public String getCommentString(Editable paramEditable)
  {
    return a(paramEditable);
  }
  
  public Editable.Factory getEditFactory()
  {
    return new QQViewBridgeImpl.1(this);
  }
  
  public View getEmotionPanel(Activity paramActivity)
  {
    return this.d.a(paramActivity);
  }
  
  public View getGifPanel(Activity paramActivity)
  {
    return this.e.a(paramActivity);
  }
  
  public int getTextLength(Editable paramEditable)
  {
    return RIJEmotionUtil.a(paramEditable);
  }
  
  public boolean hasGif()
  {
    return this.e.a != null;
  }
  
  public boolean isNightMode()
  {
    return ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    RIJCommentAtUi localRIJCommentAtUi = this.i;
    if (localRIJCommentAtUi != null) {
      localRIJCommentAtUi.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onDeleteLink()
  {
    this.c.b();
  }
  
  public void onDeliever(String paramString)
  {
    OnDeliverListener localOnDeliverListener = this.g;
    if (localOnDeliverListener != null) {
      localOnDeliverListener.b(a(paramString));
    }
  }
  
  public void onDestroy(boolean paramBoolean)
  {
    this.c.a();
    this.d.a();
    this.e.a();
    RIJCommentTopicUi localRIJCommentTopicUi = this.h;
    if (localRIJCommentTopicUi != null)
    {
      localRIJCommentTopicUi.a();
      this.h = null;
    }
    a(paramBoolean);
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void openLink(ViewGroup paramViewGroup)
  {
    InputMethodUtil.b(this.b);
    QQViewBridgeImpl.LinkUi.a(this.c, paramViewGroup.getContext());
  }
  
  public void packageDataInfo(JSONObject paramJSONObject, Editable paramEditable)
  {
    this.a.d.a(paramJSONObject, getCommentString(paramEditable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQViewBridgeImpl
 * JD-Core Version:    0.7.0.1
 */