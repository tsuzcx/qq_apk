package com.tencent.mobileqq.data;

import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.webkit.URLUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.NearbyGrayTipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.INearbyRelevantHandler;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.nearby.api.IFaceScoreUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class MessageForNearbyMarketGrayTips$HightlightClickableSpan
  extends ClickableSpan
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private MessageForNearbyMarketGrayTips jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyMarketGrayTips;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private int jdField_b_of_type_Int;
  private WeakReference<Context> jdField_b_of_type_JavaLangRefWeakReference;
  private int c;
  private int d;
  private int e = 2147483647;
  
  public MessageForNearbyMarketGrayTips$HightlightClickableSpan(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, MessageForNearbyMarketGrayTips paramMessageForNearbyMarketGrayTips)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.c = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt3;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.d = paramInt4;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyMarketGrayTips = paramMessageForNearbyMarketGrayTips;
  }
  
  public String a(int paramInt, boolean paramBoolean)
  {
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      return null;
    }
    localObject = (NearbyGrayTipsManager)((QQAppInterface)localObject).getManager(QQManagerFactory.NEARBY_GRAY_TIPS_MANAGER);
    if (localObject != null) {
      return ((NearbyGrayTipsManager)localObject).a(this.c, paramInt, paramBoolean);
    }
    return "";
  }
  
  public String a(boolean paramBoolean)
  {
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      return null;
    }
    localObject = (NearbyGrayTipsManager)((QQAppInterface)localObject).getManager(QQManagerFactory.NEARBY_GRAY_TIPS_MANAGER);
    if (localObject != null) {
      return ((NearbyGrayTipsManager)localObject).a(this.c, paramBoolean);
    }
    return "";
  }
  
  public void a(String paramString)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clickJumpWeb, url = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("MessageForNearbyMarketGrayTips", 4, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Context localContext = (Context)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if (localContext == null) {
      return;
    }
    Object localObject = paramString;
    if (paramString.contains("strangerUin=xxx"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("strangerUin=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyMarketGrayTips.frienduin);
      localObject = paramString.replace("strangerUin=xxx", ((StringBuilder)localObject).toString());
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    paramString = (String)localObject;
    if (localQQAppInterface != null)
    {
      paramString = (String)localObject;
      if (((String)localObject).contains("sign=xxx")) {
        if (1001 == this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyMarketGrayTips.istroop)
        {
          paramString = new StringBuilder();
          paramString.append("sign=");
          paramString.append(Utils.a(localQQAppInterface.getMsgCache().m(this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyMarketGrayTips.frienduin)));
          paramString = ((String)localObject).replace("sign=xxx", paramString.toString());
        }
        else if (1010 == this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyMarketGrayTips.istroop)
        {
          paramString = new StringBuilder();
          paramString.append("sign=");
          paramString.append(Utils.a(localQQAppInterface.getMsgCache().p(this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyMarketGrayTips.frienduin)));
          paramString = ((String)localObject).replace("sign=xxx", paramString.toString());
        }
        else
        {
          paramString = (String)localObject;
          if (10002 == this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyMarketGrayTips.istroop)
          {
            paramString = new StringBuilder();
            paramString.append("sign=");
            paramString.append(Utils.a(localQQAppInterface.getMsgCache().j(this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyMarketGrayTips.frienduin)));
            paramString = ((String)localObject).replace("sign=xxx", paramString.toString());
          }
        }
      }
      localObject = paramString;
      if (paramString.contains("sourceType=xxx")) {
        if (1001 == this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyMarketGrayTips.istroop)
        {
          localObject = paramString.replace("sourceType=xxx", "sourceType=1");
        }
        else
        {
          localObject = paramString;
          if (1010 == this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyMarketGrayTips.istroop) {
            localObject = paramString.replace("sourceType=xxx", "sourceType=2");
          }
        }
      }
      paramString = (String)localObject;
      if (((String)localObject).equals("https://imgcache.qq.com/club/client/flower/release/html/index.html"))
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyMarketGrayTips.frienduin;
        localObject = Utils.a(localQQAppInterface.getMsgCache().m(paramString));
        localObject = String.format("https://imgcache.qq.com/club/client/flower/release/html/index.html?strangerUin=%s&sign=%s&sourceType=%d&ADTAG=%s&groupCode=%s&_wv=2147347&_bid=2050", new Object[] { NearbyURLSafeUtil.a(paramString), ((String)localObject).toLowerCase(), Integer.valueOf(1), "aio.plus.s", "" });
        paramString = (String)localObject;
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("jump flow store, ");
          paramString.append((String)localObject);
          QLog.i("MessageForNearbyMarketGrayTips", 2, paramString.toString());
          paramString = (String)localObject;
        }
      }
    }
    localObject = new Intent(localContext, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", URLUtil.guessUrl(paramString));
    localContext.startActivity((Intent)localObject);
  }
  
  public void b(String paramString)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clickJumpNative, schema = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("MessageForNearbyMarketGrayTips", 4, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Context localContext = (Context)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    if (localObject != null)
    {
      if (localContext == null) {
        return;
      }
      localObject = JumpParser.a((BaseQQAppInterface)localObject, localContext, paramString);
      if (localObject != null)
      {
        ((JumpAction)localObject).a();
        return;
      }
      a(paramString);
    }
  }
  
  public void c(String paramString)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clickAutoInput, content = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("MessageForNearbyMarketGrayTips", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {
      return;
    }
    long l = Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long);
    if (l > 5000L)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("clickAutoInput, time = ");
        paramString.append(l);
        QLog.i("MessageForNearbyMarketGrayTips", 2, paramString.toString());
      }
      return;
    }
    ((INearbyRelevantHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.NEARBY_RELEVANT_HANDLER)).a("tag_nearby_chat", paramString, null);
    ThreadManager.post(new MessageForNearbyMarketGrayTips.HightlightClickableSpan.4(this, (QQAppInterface)localObject), 2, null, false);
  }
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface != null)
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X800524C", "0X800524C", 0, 0, String.valueOf(this.c), "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyMarketGrayTips.AioType == 0) {
        paramView = "0";
      } else {
        paramView = "1";
      }
      ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "tmp_grey", "clk_link", 0, 0, paramView, "", "", "");
    }
    int i = this.jdField_b_of_type_Int;
    if (i != 0) {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              return;
            }
            this.jdField_a_of_type_Long = System.currentTimeMillis();
            if (QLog.isColorLevel())
            {
              paramView = new StringBuilder();
              paramView.append("ACTION_AUTO_INPUT_FACE_SCORE. mGender=");
              paramView.append(this.e);
              QLog.d("MessageForNearbyMarketGrayTipsQ..troop.faceScore", 2, paramView.toString());
            }
            if (localQQAppInterface != null)
            {
              paramView = (IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class);
              Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyMarketGrayTips;
              IFaceScoreUtils localIFaceScoreUtils1 = (IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class);
              boolean bool = paramView.getFaceScoreFlag((MessageRecord)localObject, "isFaceScoreSecondMember");
              localObject = "2";
              if (bool) {
                paramView = "2";
              } else {
                paramView = "1";
              }
              localIFaceScoreUtils1 = (IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class);
              MessageForNearbyMarketGrayTips localMessageForNearbyMarketGrayTips = this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyMarketGrayTips;
              IFaceScoreUtils localIFaceScoreUtils2 = (IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class);
              if (!localIFaceScoreUtils1.getFaceScoreFlag(localMessageForNearbyMarketGrayTips, "isFaceScoreSpecialLike")) {
                localObject = "1";
              }
              ((IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class)).report("clk_hi", this.jdField_a_of_type_ComTencentMobileqqDataMessageForNearbyMarketGrayTips.frienduin, new String[] { paramView, "", "", localObject });
              i = this.e;
              if (i == 2147483647)
              {
                ThreadManager.post(new MessageForNearbyMarketGrayTips.HightlightClickableSpan.2(this, localQQAppInterface), 5, null, true);
                return;
              }
              paramView = a(i, false);
              if (TextUtils.isEmpty(paramView))
              {
                ThreadManager.post(new MessageForNearbyMarketGrayTips.HightlightClickableSpan.3(this), 5, null, true);
                return;
              }
              c(paramView);
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("ACTION_AUTO_INPUT_FACE_SCORE. from cache. FaceScoreWording=");
                ((StringBuilder)localObject).append(paramView);
                QLog.d("MessageForNearbyMarketGrayTipsQ..troop.faceScore", 2, ((StringBuilder)localObject).toString());
              }
            }
          }
          else
          {
            this.jdField_a_of_type_Long = System.currentTimeMillis();
            paramView = a(false);
            if (TextUtils.isEmpty(paramView))
            {
              ThreadManager.post(new MessageForNearbyMarketGrayTips.HightlightClickableSpan.1(this), 5, null, true);
              return;
            }
            c(paramView);
          }
        }
        else {
          b(this.jdField_a_of_type_JavaLangString);
        }
      }
      else {
        a(this.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    int i = this.jdField_a_of_type_Int;
    if (i == -1) {
      paramTextPaint.setColor(paramTextPaint.linkColor);
    } else {
      paramTextPaint.setColor(i);
    }
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips.HightlightClickableSpan
 * JD-Core Version:    0.7.0.1
 */