import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.29.1;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.29.10;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.29.2;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.29.3;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.29.4;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.29.5;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.29.6;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.29.7;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.29.8;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.29.9;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

public class qot
  implements INetInfoHandler
{
  qot(qoe paramqoe) {}
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: mobile -> none");
    }
    qoe.a(this.a).b(false);
    if ((!this.a.a()) || (!this.a.jdField_a_of_type_Boolean)) {}
    while (!this.a.jdField_a_of_type_Qhp.a()) {
      return;
    }
    this.a.jdField_a_of_type_Qhp.a();
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: wifi -> mobile");
    }
    if (this.a.c == 70) {
      qoe.a(this.a).post(new ReadInJoyBaseAdapter.29.9(this));
    }
    do
    {
      return;
      qoe.a(this.a).b(true);
    } while ((!this.a.a()) || (!this.a.jdField_a_of_type_Boolean));
    qoe.a(this.a).post(new ReadInJoyBaseAdapter.29.10(this));
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: none -> mobile");
    }
    if (this.a.c == 70) {
      qoe.a(this.a).post(new ReadInJoyBaseAdapter.29.1(this));
    }
    do
    {
      do
      {
        return;
        if (qoe.a(this.a) != null) {
          qoe.a(this.a).b(false);
        }
      } while ((!this.a.a()) || (!this.a.jdField_a_of_type_Boolean));
      if ((!this.a.jdField_a_of_type_Qhp.a()) && (!this.a.jdField_a_of_type_Qhp.c()) && (qoe.a(this.a).a()))
      {
        qoe.a(this.a).post(new ReadInJoyBaseAdapter.29.2(this));
        return;
      }
      if ((this.a.jdField_a_of_type_Omw != null) && (this.a.jdField_a_of_type_Qhp.c()) && (this.a.jdField_a_of_type_Qhp.b() == this.a.jdField_a_of_type_Omw.a().c) && (qoe.a(this.a).a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "net change: continue to play before video ,id : " + this.a.jdField_a_of_type_Qhp.b());
        }
        this.a.jdField_a_of_type_Qhp.c();
        return;
      }
    } while ((this.a.jdField_a_of_type_Qht == null) || (!this.a.jdField_a_of_type_Qhp.c()) || (this.a.jdField_a_of_type_Qhp.b() != this.a.jdField_a_of_type_Qht.c) || (!qoe.a(this.a).a()));
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "mVideoPlayParam net change: continue to play before video ,id : " + this.a.jdField_a_of_type_Qhp.b());
    }
    this.a.jdField_a_of_type_Qhp.c();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: none -> wifi");
    }
    if (this.a.c == 70) {
      qoe.a(this.a).post(new ReadInJoyBaseAdapter.29.7(this));
    }
    do
    {
      do
      {
        return;
        qoe.a(this.a).b(true);
      } while ((!this.a.a()) || (!this.a.jdField_a_of_type_Boolean));
      if ((!this.a.jdField_a_of_type_Qhp.a()) && (!this.a.jdField_a_of_type_Qhp.c()))
      {
        qoe.a(this.a).post(new ReadInJoyBaseAdapter.29.8(this));
        return;
      }
      if ((this.a.jdField_a_of_type_Omw != null) && (this.a.jdField_a_of_type_Qhp.c()) && (this.a.jdField_a_of_type_Qhp.b() == this.a.jdField_a_of_type_Omw.a().c))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "net change: continue to play before video ,id : " + this.a.jdField_a_of_type_Qhp.b());
        }
        this.a.jdField_a_of_type_Qhp.c();
        return;
      }
    } while ((this.a.jdField_a_of_type_Qht == null) || (!this.a.jdField_a_of_type_Qhp.c()) || (this.a.jdField_a_of_type_Qhp.b() != this.a.jdField_a_of_type_Qht.c));
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "mVideoPlayParam net change: continue to play before video ,id : " + this.a.jdField_a_of_type_Qhp.b());
    }
    this.a.jdField_a_of_type_Qhp.c();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: wifi -> mobile,forwarding event to none2mobile handle");
    }
    if (this.a.c == 70) {
      qoe.a(this.a).post(new ReadInJoyBaseAdapter.29.5(this));
    }
    do
    {
      return;
      qoe.a(this.a).b(false);
    } while ((this.a.j) || (this.a.jdField_a_of_type_Omw == null) || (this.a.jdField_a_of_type_Qht == null));
    qoe.a(this.a).post(new ReadInJoyBaseAdapter.29.6(this));
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: wifi -> none.");
    }
    if (this.a.c == 70) {
      qoe.a(this.a).post(new ReadInJoyBaseAdapter.29.3(this));
    }
    do
    {
      return;
      qoe.a(this.a).b(false);
    } while ((this.a.j) || (this.a.jdField_a_of_type_Omw == null) || (this.a.jdField_a_of_type_Qht == null));
    qoe.a(this.a).post(new ReadInJoyBaseAdapter.29.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qot
 * JD-Core Version:    0.7.0.1
 */