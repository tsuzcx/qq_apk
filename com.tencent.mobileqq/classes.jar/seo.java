import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.VideoCountDownView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;

public class seo
  implements Handler.Callback, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private VideoCountDownView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView;
  private String jdField_a_of_type_JavaLangString;
  private List<seq> jdField_a_of_type_JavaUtilList;
  private Queue<ruh> jdField_a_of_type_JavaUtilQueue = new ArrayDeque();
  private ocf jdField_a_of_type_Ocf;
  private ocg jdField_a_of_type_Ocg;
  private ruh jdField_a_of_type_Ruh;
  private ruu jdField_a_of_type_Ruu;
  private ser jdField_a_of_type_Ser;
  private ses jdField_a_of_type_Ses;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ruh jdField_b_of_type_Ruh;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private ruh jdField_c_of_type_Ruh;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = true;
  private boolean e;
  
  public seo(Activity paramActivity, FrameLayout paramFrameLayout, ses paramses)
  {
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
    this.jdField_a_of_type_Ses = paramses;
    this.jdField_a_of_type_AndroidOsHandler = new bkgm(this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramActivity = pha.a();
    if ((paramActivity != null) && ((paramActivity instanceof QQAppInterface)))
    {
      paramActivity = (QQAppInterface)paramActivity;
      this.jdField_a_of_type_Ocf = ((ocf)paramActivity.a(90));
      this.jdField_a_of_type_Ocg = new set(this, null);
      this.jdField_a_of_type_JavaLangString = paramActivity.c();
    }
  }
  
  private void a(ruh paramruh1, ruh paramruh2)
  {
    if (((paramruh1 instanceof sey)) && ((paramruh2 instanceof sey)))
    {
      paramruh1 = (sey)paramruh1;
      paramruh2 = (sey)paramruh2;
    }
    try
    {
      paramruh2 = paramruh2.a;
      if (paramruh2 != null)
      {
        paramruh2.mChannelID = paramruh1.a.mChannelID;
        paramruh2.mRecommendTime = paramruh1.a.mRecommendTime;
      }
      return;
    }
    catch (Throwable paramruh1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("VideoFullPlayController", 2, "fixNextPlayVideoPlayParam error:" + paramruh1.getMessage());
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_Ocf != null) && (this.jdField_b_of_type_Ruh != null)) {
      this.jdField_a_of_type_Ocf.a(this.jdField_a_of_type_Ocg, Long.parseLong(this.jdField_a_of_type_JavaLangString), this.jdField_b_of_type_Ruh.a(), 17, null, null, 0L, false, 0, null, null, null, 0, null, null, 0, null);
    }
  }
  
  private void h()
  {
    if (((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) && (this.jdField_a_of_type_Ocg != null)) {
      ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).removeObserver(this.jdField_a_of_type_Ocg);
    }
  }
  
  private void i()
  {
    this.jdField_c_of_type_Ruh.jdField_a_of_type_Int = (this.jdField_b_of_type_Ruh.jdField_a_of_type_Int + 1);
    a(this.jdField_b_of_type_Ruh, this.jdField_c_of_type_Ruh);
  }
  
  private void j()
  {
    if ((this.jdField_c_of_type_Ruh != null) && (this.jdField_a_of_type_Ruu != null))
    {
      this.jdField_a_of_type_JavaUtilQueue.remove(this.jdField_c_of_type_Ruh);
      if (this.jdField_a_of_type_Ser != null) {
        this.jdField_a_of_type_Ser.a(this.jdField_b_of_type_Ruh, this.jdField_c_of_type_Ruh, this.jdField_b_of_type_Int, this.e);
      }
      this.jdField_a_of_type_Ruu.a(this.jdField_c_of_type_Ruh);
      this.jdField_d_of_type_Int += 1;
    }
    this.jdField_c_of_type_Ruh = null;
    this.e = false;
  }
  
  public String a()
  {
    return String.valueOf(this.jdField_c_of_type_Int);
  }
  
  public String a(String paramString)
  {
    JSONObject localJSONObject1;
    try
    {
      localJSONObject1 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        seq localseq = (seq)localIterator.next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("rowKey", localseq.jdField_a_of_type_Ruh.a());
        localJSONObject2.put("playCount", localseq.jdField_a_of_type_Int);
        localJSONArray.put(localJSONObject2);
      }
      localJSONObject1.put("playInfo_list", localJSONArray);
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    localJSONObject1.put("first_rowKey", paramString);
    paramString = localJSONObject1.toString();
    return paramString;
  }
  
  public List<seq> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public ruh a()
  {
    return this.jdField_b_of_type_Ruh;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_b_of_type_Ruh != null) {
      this.jdField_a_of_type_JavaUtilList.add(new seq(this.jdField_b_of_type_Ruh, this.jdField_d_of_type_Int));
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFullPlayController", 2, "exitFullMode: ");
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (!b()) {
      return;
    }
    if (this.jdField_a_of_type_Int > 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.a(paramInt);
      a(paramInt, System.currentTimeMillis());
      return;
    }
    if (this.jdField_c_of_type_Ruh != null)
    {
      b();
      j();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.a();
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (paramInt <= 0) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.arg1 = paramInt;
    localMessage.obj = Long.valueOf(paramLong);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 500L);
  }
  
  public void a(ruh paramruh)
  {
    boolean bool = true;
    this.jdField_b_of_type_Boolean = true;
    if (!bgnt.h(this.jdField_a_of_type_AndroidContentContext))
    {
      this.jdField_c_of_type_Boolean = bool;
      if (QLog.isColorLevel()) {
        QLog.i("VideoFullPlayController", 2, "enterCountDownMode videoPlayParam:" + paramruh + " mVideoRootFrameLayout:" + this.jdField_a_of_type_AndroidWidgetFrameLayout);
      }
      if (((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) && (this.jdField_a_of_type_Ocg != null)) {
        ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).addObserver(this.jdField_a_of_type_Ocg);
      }
      if ((paramruh != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout != null))
      {
        this.jdField_a_of_type_Ruh = paramruh;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView == null)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView = new VideoCountDownView(this.jdField_a_of_type_AndroidContentContext);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setOnClickListener(null);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setOnCustomClickListener(this);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.c();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setTitle(paramruh.jdField_a_of_type_JavaLangString);
        if (!this.jdField_d_of_type_Boolean) {
          break label302;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.a(tyc.a(paramruh.jdField_b_of_type_JavaLangString, 0));
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.getParent()).removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView);
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView);
      f();
      paramruh = new skc(null, null, paramruh.c, paramruh.a()).a((int)paramruh.jdField_b_of_type_Long).a().a();
      oat.a(null, "", "0X8009502", "0X8009502", 0, 0, "", String.valueOf(this.jdField_c_of_type_Int), "", paramruh, false);
      return;
      bool = false;
      break;
      label302:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.b();
    }
  }
  
  public void a(ruh paramruh, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoFullPlayController", 2, "enterFullMode videoPlayParam:" + paramruh);
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Ruh = paramruh;
    this.jdField_d_of_type_Int = 1;
    this.jdField_b_of_type_Int = paramInt;
    this.e = true;
    this.jdField_a_of_type_JavaUtilQueue.clear();
    if (this.jdField_b_of_type_Ruh != null)
    {
      if (paramruh.jdField_b_of_type_Long == 409409L) {
        this.jdField_c_of_type_Int = 0;
      }
    }
    else {
      return;
    }
    if (paramruh.jdField_b_of_type_Long == 56L)
    {
      this.jdField_c_of_type_Int = 1;
      return;
    }
    this.jdField_c_of_type_Int = 2;
  }
  
  public void a(ruu paramruu)
  {
    this.jdField_a_of_type_Ruu = paramruu;
  }
  
  public void a(ser paramser)
  {
    this.jdField_a_of_type_Ser = paramser;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView);
    h();
  }
  
  public void b(ruh paramruh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFullPlayController", 2, "onFetch nextVideoPlayParam:" + paramruh);
    }
    this.jdField_c_of_type_Ruh = paramruh;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setIsXgMode(this.jdField_c_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoCountDownView.setNextVideoInfo(paramruh);
    if (!this.jdField_c_of_type_Boolean) {
      a(3);
    }
    i();
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void c()
  {
    if (!this.jdField_c_of_type_Boolean) {
      a(this.jdField_a_of_type_Int);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
  }
  
  public void e()
  {
    h();
    this.jdField_a_of_type_Ocf = null;
  }
  
  public void f()
  {
    ruh localruh = (ruh)this.jdField_a_of_type_JavaUtilQueue.peek();
    if (localruh == null)
    {
      g();
      return;
    }
    b(localruh);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      long l = System.currentTimeMillis() - ((Long)paramMessage.obj).longValue();
      if (l >= 1000L)
      {
        paramMessage.arg1 = ((int)(paramMessage.arg1 - l / 1000L));
        a(paramMessage.arg1);
      }
    }
    else
    {
      return true;
    }
    a(paramMessage.arg1, ((Long)paramMessage.obj).longValue());
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b();
      if (this.jdField_a_of_type_Ruu != null) {
        this.jdField_a_of_type_Ruu.a(this.jdField_a_of_type_Ruh);
      }
      if (this.jdField_a_of_type_Ruh != null)
      {
        String str = new skc(null, null, this.jdField_a_of_type_Ruh.c, this.jdField_a_of_type_Ruh.a()).a((int)this.jdField_a_of_type_Ruh.jdField_b_of_type_Long).a().a();
        oat.a(null, "", "0X8009503", "0X8009503", 0, 0, "", String.valueOf(this.jdField_c_of_type_Int), "", str, false);
        continue;
        if (this.jdField_a_of_type_Ser != null)
        {
          this.jdField_a_of_type_Ser.j();
          continue;
          if (this.jdField_c_of_type_Ruh != null)
          {
            str = new skc(null, null, this.jdField_c_of_type_Ruh.c, this.jdField_c_of_type_Ruh.a()).a((int)this.jdField_c_of_type_Ruh.jdField_b_of_type_Long).h(this.jdField_c_of_type_Ruh.a()).a().a();
            oat.a(null, "", "0X8009504", "0X8009504", 0, 0, "", String.valueOf(this.jdField_c_of_type_Int), "", str, false);
            b();
            j();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     seo
 * JD-Core Version:    0.7.0.1
 */