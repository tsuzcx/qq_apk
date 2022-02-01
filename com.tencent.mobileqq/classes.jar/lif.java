import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.qphone.base.util.QLog;

public class lif
  extends lhy
{
  public static final String[] b = { "params.dat" };
  
  public lif(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.c = b;
  }
  
  public int a()
  {
    return 623;
  }
  
  public lia a(int paramInt1, int paramInt2)
  {
    lia locallia = super.a(paramInt1, paramInt2);
    if ((locallia != null) && (locallia.a != null) && (!locallia.a.needHMirror)) {
      locallia.a.needHMirror = true;
    }
    return locallia;
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
      lgz locallgz = (lgz)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(12);
      if (locallgz != null) {
        locallgz.a(3005, paramPendantItem.getId());
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
 * Qualified Name:     lif
 * JD-Core Version:    0.7.0.1
 */