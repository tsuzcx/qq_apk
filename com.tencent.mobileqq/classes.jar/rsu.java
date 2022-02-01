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

public class rsu
  implements INetInfoHandler
{
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private final ped jdField_a_of_type_Ped;
  private final psf jdField_a_of_type_Psf;
  private final slt jdField_a_of_type_Slt;
  
  public rsu(psf parampsf)
  {
    this.jdField_a_of_type_Psf = parampsf;
    this.jdField_a_of_type_Slt = parampsf.a();
    this.jdField_a_of_type_Ped = parampsf.a();
  }
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: mobile -> none");
    }
    this.jdField_a_of_type_Psf.a().b(false);
    if ((!this.jdField_a_of_type_Slt.a()) || (!this.jdField_a_of_type_Psf.b())) {}
    sdc localsdc;
    do
    {
      return;
      localsdc = this.jdField_a_of_type_Psf.a();
    } while (!localsdc.b());
    localsdc.a();
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: wifi -> mobile");
    }
    if (this.jdField_a_of_type_Psf.b() == 70) {
      this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.9(this));
    }
    do
    {
      return;
      this.jdField_a_of_type_Psf.a().b(true);
    } while ((!this.jdField_a_of_type_Slt.a()) || (!this.jdField_a_of_type_Psf.b()));
    this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.10(this));
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: none -> mobile");
    }
    if (this.jdField_a_of_type_Psf.b() == 70) {
      this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.1(this));
    }
    sdg localsdg;
    do
    {
      int i;
      do
      {
        do
        {
          return;
          paramString = this.jdField_a_of_type_Psf.a();
          if (paramString != null) {
            paramString.b(false);
          }
        } while ((!this.jdField_a_of_type_Slt.a()) || (!this.jdField_a_of_type_Psf.b()));
        i = j;
        if (paramString != null)
        {
          i = j;
          if (paramString.a()) {
            i = 1;
          }
        }
      } while (i == 0);
      paramString = this.jdField_a_of_type_Psf.a();
      localsdg = paramString.a();
      if ((!paramString.b()) && (!paramString.d()))
      {
        this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.2(this));
        return;
      }
      if ((paramString.d()) && (localsdg != null) && (paramString.b() == localsdg.c))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "net change: continue to play before video ,id : " + paramString.b());
        }
        paramString.c();
        return;
      }
    } while ((localsdg == null) || (!paramString.d()) || (paramString.b() != localsdg.c));
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
    if (this.jdField_a_of_type_Psf.b() == 70) {
      this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.7(this));
    }
    sdg localsdg;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Psf.a().b(true);
      } while ((!this.jdField_a_of_type_Slt.a()) || (!this.jdField_a_of_type_Psf.b()));
      paramString = this.jdField_a_of_type_Psf.a();
      localsdg = paramString.a();
      if ((!paramString.b()) && (!paramString.d()))
      {
        this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.8(this));
        return;
      }
      if ((localsdg != null) && (paramString.b() == localsdg.c) && (paramString.d()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "net change: continue to play before video ,id : " + paramString.b());
        }
        paramString.c();
        return;
      }
    } while ((localsdg == null) || (paramString.b() != localsdg.c) || (!paramString.d()));
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
    if (this.jdField_a_of_type_Psf.b() == 70) {
      this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.5(this));
    }
    int i;
    do
    {
      return;
      this.jdField_a_of_type_Psf.a().b(false);
      paramString = this.jdField_a_of_type_Psf.a();
      i = j;
      if (paramString != null)
      {
        i = j;
        if (this.jdField_a_of_type_Psf.a() != null)
        {
          i = j;
          if (paramString.a() != null) {
            i = 1;
          }
        }
      }
    } while ((i == 0) || (this.jdField_a_of_type_Ped.a().g()));
    this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.6(this, paramString));
  }
  
  public void onNetWifi2None()
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: wifi -> none.");
    }
    if (this.jdField_a_of_type_Psf.b() == 70) {
      this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.3(this));
    }
    sdc localsdc;
    int i;
    do
    {
      return;
      this.jdField_a_of_type_Psf.a().b(false);
      localsdc = this.jdField_a_of_type_Psf.a();
      i = j;
      if (localsdc != null)
      {
        i = j;
        if (this.jdField_a_of_type_Psf.a() != null)
        {
          i = j;
          if (localsdc.a() != null) {
            i = 1;
          }
        }
      }
    } while ((i == 0) || (this.jdField_a_of_type_Ped.a().g()));
    this.jdField_a_of_type_AndroidOsHandler.post(new NetInfoHandler.4(this, localsdc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rsu
 * JD-Core Version:    0.7.0.1
 */