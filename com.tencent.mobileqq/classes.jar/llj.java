import android.content.SharedPreferences;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.voiceRecog.VoiceRecogTips;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;

public class llj
  extends ljg
{
  VoiceRecogTips a;
  
  public llj(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvBusinessManagerVoiceRecogVoiceRecogTips = null;
  }
  
  public static SharedPreferences a(AppInterface paramAppInterface)
  {
    return paramAppInterface.getApp().getSharedPreferences(paramAppInterface.getCurrentAccountUin() + "qav_voicerecog", 0);
  }
  
  public static ljv a(VideoAppInterface paramVideoAppInterface)
  {
    paramVideoAppInterface = ((lju)paramVideoAppInterface.a(3)).a();
    long l = ayvc.a();
    paramVideoAppInterface = paramVideoAppInterface.iterator();
    while (paramVideoAppInterface.hasNext())
    {
      ljv localljv = (ljv)paramVideoAppInterface.next();
      if (a(l * 1000L, localljv.a, localljv.b)) {
        return localljv;
      }
    }
    return null;
  }
  
  public static boolean a(long paramLong1, long paramLong2, long paramLong3)
  {
    return (paramLong1 >= paramLong2) && (paramLong1 <= paramLong3);
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface)
  {
    return (lvt.b()) && (b(paramVideoAppInterface));
  }
  
  public static boolean b(VideoAppInterface paramVideoAppInterface)
  {
    return ((llc)paramVideoAppInterface.a(5)).a(3, "normal");
  }
  
  protected void a() {}
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (1 == paramInt) {
      b();
    }
    while (3 != paramInt) {
      return;
    }
    c();
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    super.a(paramString, paramBoolean);
  }
  
  protected boolean a(String paramString)
  {
    return false;
  }
  
  void b()
  {
    if (!a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {}
    lid locallid;
    ljv localljv;
    do
    {
      do
      {
        return;
        locallid = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
      } while (locallid == null);
      localljv = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    } while (localljv == null);
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerVoiceRecogVoiceRecogTips != null) {
      this.jdField_a_of_type_ComTencentAvBusinessManagerVoiceRecogVoiceRecogTips.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    this.jdField_a_of_type_ComTencentAvBusinessManagerVoiceRecogVoiceRecogTips = new VoiceRecogTips(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, locallid.d, localljv);
  }
  
  void c()
  {
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerVoiceRecogVoiceRecogTips != null)
    {
      this.jdField_a_of_type_ComTencentAvBusinessManagerVoiceRecogVoiceRecogTips.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      this.jdField_a_of_type_ComTencentAvBusinessManagerVoiceRecogVoiceRecogTips = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     llj
 * JD-Core Version:    0.7.0.1
 */