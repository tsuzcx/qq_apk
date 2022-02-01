import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.NetInfoHandler.1;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.NetInfoHandler.10;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.NetInfoHandler.2;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.NetInfoHandler.3;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.NetInfoHandler.4;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.NetInfoHandler.5;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.NetInfoHandler.6;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.NetInfoHandler.7;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.NetInfoHandler.8;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.NetInfoHandler.9;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

public class sgb
  implements INetInfoHandler
{
  private sgb(sel paramsel) {}
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: mobile -> none");
    }
    sel.a(this.a).b(false);
    if ((!this.a.a()) || (!this.a.jdField_a_of_type_Boolean)) {}
    while (!this.a.jdField_a_of_type_Rvy.b()) {
      return;
    }
    this.a.jdField_a_of_type_Rvy.a();
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: wifi -> mobile");
    }
    if (this.a.c == 70) {
      sel.a(this.a).post(new ReadInJoyBaseAdapter.NetInfoHandler.9(this));
    }
    do
    {
      return;
      sel.a(this.a).b(true);
    } while ((!this.a.a()) || (!this.a.jdField_a_of_type_Boolean));
    sel.a(this.a).post(new ReadInJoyBaseAdapter.NetInfoHandler.10(this));
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: none -> mobile");
    }
    if (this.a.c == 70) {
      sel.a(this.a).post(new ReadInJoyBaseAdapter.NetInfoHandler.1(this));
    }
    do
    {
      do
      {
        return;
        if (sel.a(this.a) != null) {
          sel.a(this.a).b(false);
        }
      } while ((!this.a.a()) || (!this.a.jdField_a_of_type_Boolean));
      if ((!this.a.jdField_a_of_type_Rvy.b()) && (!this.a.jdField_a_of_type_Rvy.d()) && (sel.a(this.a).a()))
      {
        sel.a(this.a).post(new ReadInJoyBaseAdapter.NetInfoHandler.2(this));
        return;
      }
      if ((this.a.jdField_a_of_type_Pmw != null) && (this.a.jdField_a_of_type_Rvy.d()) && (this.a.jdField_a_of_type_Rvy.b() == this.a.jdField_a_of_type_Pmw.a().c) && (sel.a(this.a).a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "net change: continue to play before video ,id : " + this.a.jdField_a_of_type_Rvy.b());
        }
        this.a.jdField_a_of_type_Rvy.c();
        return;
      }
    } while ((this.a.jdField_a_of_type_Rwc == null) || (!this.a.jdField_a_of_type_Rvy.d()) || (this.a.jdField_a_of_type_Rvy.b() != this.a.jdField_a_of_type_Rwc.c) || (!sel.a(this.a).a()));
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "mVideoPlayParam net change: continue to play before video ,id : " + this.a.jdField_a_of_type_Rvy.b());
    }
    this.a.jdField_a_of_type_Rvy.c();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: none -> wifi");
    }
    if (this.a.c == 70) {
      sel.a(this.a).post(new ReadInJoyBaseAdapter.NetInfoHandler.7(this));
    }
    do
    {
      do
      {
        return;
        sel.a(this.a).b(true);
      } while ((!this.a.a()) || (!this.a.jdField_a_of_type_Boolean));
      if ((!this.a.jdField_a_of_type_Rvy.b()) && (!this.a.jdField_a_of_type_Rvy.d()))
      {
        sel.a(this.a).post(new ReadInJoyBaseAdapter.NetInfoHandler.8(this));
        return;
      }
      if ((this.a.jdField_a_of_type_Pmw != null) && (this.a.jdField_a_of_type_Rvy.d()) && (this.a.jdField_a_of_type_Rvy.b() == this.a.jdField_a_of_type_Pmw.a().c))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "net change: continue to play before video ,id : " + this.a.jdField_a_of_type_Rvy.b());
        }
        this.a.jdField_a_of_type_Rvy.c();
        return;
      }
    } while ((this.a.jdField_a_of_type_Rwc == null) || (!this.a.jdField_a_of_type_Rvy.d()) || (this.a.jdField_a_of_type_Rvy.b() != this.a.jdField_a_of_type_Rwc.c));
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "mVideoPlayParam net change: continue to play before video ,id : " + this.a.jdField_a_of_type_Rvy.b());
    }
    this.a.jdField_a_of_type_Rvy.c();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: wifi -> mobile,forwarding event to none2mobile handle");
    }
    if (this.a.c == 70) {
      sel.a(this.a).post(new ReadInJoyBaseAdapter.NetInfoHandler.5(this));
    }
    do
    {
      return;
      sel.a(this.a).b(false);
    } while ((this.a.j) || (this.a.jdField_a_of_type_Pmw == null) || (this.a.jdField_a_of_type_Rwc == null));
    sel.a(this.a).post(new ReadInJoyBaseAdapter.NetInfoHandler.6(this));
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: wifi -> none.");
    }
    if (this.a.c == 70) {
      sel.a(this.a).post(new ReadInJoyBaseAdapter.NetInfoHandler.3(this));
    }
    do
    {
      return;
      sel.a(this.a).b(false);
    } while ((this.a.j) || (this.a.jdField_a_of_type_Pmw == null) || (this.a.jdField_a_of_type_Rwc == null));
    sel.a(this.a).post(new ReadInJoyBaseAdapter.NetInfoHandler.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sgb
 * JD-Core Version:    0.7.0.1
 */