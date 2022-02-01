import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.video.NetInfoHandler.1;
import com.tencent.biz.pubaccount.readinjoy.video.NetInfoHandler.10;
import com.tencent.biz.pubaccount.readinjoy.video.NetInfoHandler.2;
import com.tencent.biz.pubaccount.readinjoy.video.NetInfoHandler.3;
import com.tencent.biz.pubaccount.readinjoy.video.NetInfoHandler.4;
import com.tencent.biz.pubaccount.readinjoy.video.NetInfoHandler.5;
import com.tencent.biz.pubaccount.readinjoy.video.NetInfoHandler.6;
import com.tencent.biz.pubaccount.readinjoy.video.NetInfoHandler.7;
import com.tencent.biz.pubaccount.readinjoy.video.NetInfoHandler.8;
import com.tencent.biz.pubaccount.readinjoy.video.NetInfoHandler.9;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

public class sfj
  implements INetInfoHandler
{
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private final pne jdField_a_of_type_Pne;
  private final qdc jdField_a_of_type_Qdc;
  private final szd jdField_a_of_type_Szd;
  
  public sfj(qdc paramqdc)
  {
    this.jdField_a_of_type_Qdc = paramqdc;
    this.jdField_a_of_type_Szd = paramqdc.a();
    this.jdField_a_of_type_Pne = paramqdc.a();
  }
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: mobile -> none");
    }
    this.jdField_a_of_type_Qdc.a().b(false);
    if ((!this.jdField_a_of_type_Szd.a()) || (!this.jdField_a_of_type_Qdc.b())) {}
    spg localspg;
    do
    {
      return;
      localspg = this.jdField_a_of_type_Qdc.a();
    } while (!localspg.b());
    localspg.a();
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: wifi -> mobile");
    }
    if (this.jdField_a_of_type_Qdc.b() == 70) {
      this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.9(this));
    }
    do
    {
      return;
      this.jdField_a_of_type_Qdc.a().b(true);
    } while ((!this.jdField_a_of_type_Szd.a()) || (!this.jdField_a_of_type_Qdc.b()));
    this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.10(this));
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: none -> mobile");
    }
    if (this.jdField_a_of_type_Qdc.b() == 70) {
      this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.1(this));
    }
    spk localspk;
    do
    {
      int i;
      do
      {
        do
        {
          return;
          paramString = this.jdField_a_of_type_Qdc.a();
          if (paramString != null) {
            paramString.b(false);
          }
        } while ((!this.jdField_a_of_type_Szd.a()) || (!this.jdField_a_of_type_Qdc.b()));
        i = j;
        if (paramString != null)
        {
          i = j;
          if (paramString.a()) {
            i = 1;
          }
        }
      } while (i == 0);
      paramString = this.jdField_a_of_type_Qdc.a();
      localspk = paramString.a();
      if ((!paramString.b()) && (!paramString.d()))
      {
        this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.2(this));
        return;
      }
      if ((paramString.d()) && (localspk != null) && (paramString.b() == localspk.c))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "net change: continue to play before video ,id : " + paramString.b());
        }
        paramString.c();
        return;
      }
    } while ((localspk == null) || (!paramString.d()) || (paramString.b() != localspk.c));
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "mVideoPlayParam net change: continue to play before video ,id : " + paramString.b());
    }
    paramString.c();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: none -> wifi");
    }
    if (this.jdField_a_of_type_Qdc.b() == 70) {
      this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.7(this));
    }
    spk localspk;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Qdc.a().b(true);
      } while ((!this.jdField_a_of_type_Szd.a()) || (!this.jdField_a_of_type_Qdc.b()));
      paramString = this.jdField_a_of_type_Qdc.a();
      localspk = paramString.a();
      if ((!paramString.b()) && (!paramString.d()))
      {
        this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.8(this));
        return;
      }
      if ((localspk != null) && (paramString.b() == localspk.c) && (paramString.d()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "net change: continue to play before video ,id : " + paramString.b());
        }
        paramString.c();
        return;
      }
    } while ((localspk == null) || (paramString.b() != localspk.c) || (!paramString.d()));
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "mVideoPlayParam net change: continue to play before video ,id : " + paramString.b());
    }
    paramString.c();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: wifi -> mobile,forwarding event to none2mobile handle");
    }
    if (this.jdField_a_of_type_Qdc.b() == 70) {
      this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.5(this));
    }
    int i;
    do
    {
      return;
      this.jdField_a_of_type_Qdc.a().b(false);
      paramString = this.jdField_a_of_type_Qdc.a();
      i = j;
      if (paramString != null)
      {
        i = j;
        if (this.jdField_a_of_type_Qdc.a() != null)
        {
          i = j;
          if (paramString.a() != null) {
            i = 1;
          }
        }
      }
    } while ((i == 0) || (this.jdField_a_of_type_Pne.a().g()));
    this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.6(this, paramString));
  }
  
  public void onNetWifi2None()
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: wifi -> none.");
    }
    if (this.jdField_a_of_type_Qdc.b() == 70) {
      this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.3(this));
    }
    spg localspg;
    int i;
    do
    {
      return;
      this.jdField_a_of_type_Qdc.a().b(false);
      localspg = this.jdField_a_of_type_Qdc.a();
      i = j;
      if (localspg != null)
      {
        i = j;
        if (this.jdField_a_of_type_Qdc.a() != null)
        {
          i = j;
          if (localspg.a() != null) {
            i = 1;
          }
        }
      }
    } while ((i == 0) || (this.jdField_a_of_type_Pne.a().g()));
    this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.4(this, localspg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sfj
 * JD-Core Version:    0.7.0.1
 */