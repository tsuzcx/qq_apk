import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.qphone.base.util.QLog;

public class lht
  extends lhm
{
  public static final String[] b = { "params.dat" };
  
  public lht(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.c = b;
  }
  
  public int a()
  {
    return 623;
  }
  
  public lho a(int paramInt1, int paramInt2)
  {
    lho locallho = super.a(paramInt1, paramInt2);
    if ((locallho != null) && (locallho.a != null) && (!locallho.a.needHMirror)) {
      locallho.a.needHMirror = true;
    }
    return locallho;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 4, "MuteByOthers, fromMuteKey[" + paramInt + "], data[" + paramString + "]");
    }
    if (paramInt == b()) {
      return;
    }
    a(0L, null);
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      paramString1 = (PendantItem)a();
    } while ((paramString1 == null) || (TextUtils.isEmpty(paramString1.getId())));
    a(paramLong, null);
  }
  
  public boolean a(long paramLong, PendantItem paramPendantItem)
  {
    boolean bool = super.a(paramLong, paramPendantItem);
    if ((bool) && (paramPendantItem != null) && (!TextUtils.isEmpty(paramPendantItem.getId())) && (!TextUtils.equals("0", paramPendantItem.getId())))
    {
      lgn locallgn = (lgn)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(12);
      if (locallgn != null) {
        locallgn.a(3005, paramPendantItem.getId());
      }
    }
    return bool;
  }
  
  public int b()
  {
    return 3005;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lht
 * JD-Core Version:    0.7.0.1
 */