import android.text.TextUtils;
import com.tencent.av.ui.ConferenceFlyTicketActivity;
import com.tencent.av.utils.download.DownloadParams;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class jrs
  extends DiscussionObserver
{
  public jrs(ConferenceFlyTicketActivity paramConferenceFlyTicketActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    QLog.w(this.a.jdField_a_of_type_JavaLangString, 1, "onGetFlyTicket, isSuccess[" + paramBoolean + "], errorCode[" + paramInt + "], validTime[" + paramLong1 + "], sigUrl[" + paramString1 + "], shortUrl[" + paramString2 + "], discussionUin[" + paramLong2 + "], mDiscID[" + this.a.h + "]");
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(this.a.h))
      {
        this.a.jdField_a_of_type_Jrt = new jrt(this.a);
        paramString1 = new ArrayList();
        DownloadParams localDownloadParams = new DownloadParams();
        localDownloadParams.jdField_a_of_type_JavaLangString = ("http://pubacc.mobile.qq.com/mqqweb-rtx2qq/mqqweb/createConfCallback?feedkey=" + this.a.b);
        this.a.d = paramString2.substring("http://url.cn/".length(), paramString2.length() - "#flyticket".length());
        QLog.w(this.a.jdField_a_of_type_JavaLangString, 1, "onGetFlyTicket, mTicket[" + this.a.d + "]");
        localDownloadParams.jdField_a_of_type_JavaLangString = (localDownloadParams.jdField_a_of_type_JavaLangString + "&ret=0&ticket=" + this.a.d);
        paramString1.add(localDownloadParams);
        this.a.jdField_a_of_type_Jrt.execute(new ArrayList[] { paramString1 });
      }
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.c(paramLong2);
    this.a.a(1, paramInt);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt)
  {
    QLog.w(this.a.jdField_a_of_type_JavaLangString, 1, "onJoinDiscussionByFlyTicket, isSuccess[" + paramBoolean + "], discussUin[" + paramLong + "], errorCode[" + paramInt + "], mDiscID[" + this.a.h + "]");
    if (paramBoolean)
    {
      this.a.h = String.valueOf(paramLong);
      if (!TextUtils.isEmpty(this.a.h)) {
        ((DiscussionHandler)this.a.app.a(6)).a(paramLong);
      }
      return;
    }
    this.a.a(1, paramInt);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    QLog.w(this.a.jdField_a_of_type_JavaLangString, 1, "DiscussObserver.onUpdate, type[" + paramInt + "], isSuccess[" + paramBoolean + "], mDiscID[" + this.a.h + "]");
    if (paramInt == 1001)
    {
      AudioHelper.b("获取讨论组资料_rsp");
      if ((paramObject instanceof ArrayList))
      {
        paramObject = (ArrayList)paramObject;
        paramObject = new Object[] { String.valueOf(paramObject.get(0)), paramObject.get(1) };
        str = (String)paramObject[0];
        ((Boolean)paramObject[1]).booleanValue();
        if ((this.a.h.equals(str)) && (paramBoolean))
        {
          this.a.c();
          this.a.a(this.a.h, this.a.c);
        }
        this.a.finish();
      }
    }
    while (1014 != paramInt) {
      for (;;)
      {
        String str;
        return;
        paramObject = (Object[])paramObject;
      }
    }
    AudioHelper.b("通过签名加入讨论组_rsp");
    paramObject = (Long[])paramObject;
    long l = paramObject[1].longValue();
    paramInt = paramObject[0].intValue();
    QLog.w(this.a.jdField_a_of_type_JavaLangString, 1, "NOTIFY_TYPE_JOIN_DISCUSSION_BY_FLYY_TICKET, discussUin[" + l + "], errCode[" + paramInt + "], mDiscID[" + this.a.h + "]");
    if (paramInt == 0)
    {
      if (TextUtils.equals(String.valueOf(l), this.a.h))
      {
        this.a.c();
        AudioHelper.b("获取讨论组资料");
        ((DiscussionHandler)this.a.app.a(6)).a(l);
        return;
      }
      this.a.finish();
      return;
    }
    this.a.finish();
    this.a.a(1, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jrs
 * JD-Core Version:    0.7.0.1
 */