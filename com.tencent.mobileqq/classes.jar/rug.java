import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.util.ReadInJoyShareHelper.3;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class rug
  implements Handler.Callback, AdapterView.OnItemClickListener
{
  private int jdField_a_of_type_Int = -1;
  public Activity a;
  public bahv a;
  private befq jdField_a_of_type_Befq;
  private bemt jdField_a_of_type_Bemt = new rui(this);
  private qno jdField_a_of_type_Qno;
  private rrt jdField_a_of_type_Rrt;
  private ruj jdField_a_of_type_Ruj;
  private ruk jdField_a_of_type_Ruk;
  protected rul a;
  private rvs jdField_a_of_type_Rvs;
  
  public rug() {}
  
  public rug(Activity paramActivity, AppInterface paramAppInterface, rul paramrul, ruj paramruj)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Rul = paramrul;
    if (this.jdField_a_of_type_Rul == null) {
      this.jdField_a_of_type_Rul = new rul();
    }
    this.jdField_a_of_type_Ruj = paramruj;
    if (this.jdField_a_of_type_Bahv == null) {
      this.jdField_a_of_type_Bahv = new bahv(this.jdField_a_of_type_AndroidAppActivity);
    }
    this.jdField_a_of_type_Rvs = new rvs(paramAppInterface);
    this.jdField_a_of_type_Befq = new befq(this);
  }
  
  public static List<Integer> a()
  {
    ArrayList localArrayList = new ArrayList(8);
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(4));
    localArrayList.add(Integer.valueOf(5));
    localArrayList.add(Integer.valueOf(6));
    localArrayList.add(Integer.valueOf(7));
    localArrayList.add(Integer.valueOf(8));
    return localArrayList;
  }
  
  private boolean a(ArrayList<bahx> paramArrayList, int paramInt, ruo paramruo)
  {
    if (paramruo != null)
    {
      paramruo = paramruo.a(Integer.valueOf(paramInt));
      if (paramruo != null)
      {
        paramArrayList.add(paramruo);
        return true;
      }
    }
    return false;
  }
  
  public bahv a(List<Integer>[] paramArrayOfList)
  {
    this.jdField_a_of_type_Bahv.a(a(paramArrayOfList, this.jdField_a_of_type_Rul));
    this.jdField_a_of_type_Bahv.a(this);
    this.jdField_a_of_type_Bahv.a();
    return this.jdField_a_of_type_Bahv;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bahv.a()) {
      this.jdField_a_of_type_Bahv.b();
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Rrt == null) {
      this.jdField_a_of_type_Rrt = new rrt(this.jdField_a_of_type_AndroidAppActivity, new ruh(this));
    }
    this.jdField_a_of_type_Rrt.a(paramString);
  }
  
  public void a(ruj paramruj)
  {
    this.jdField_a_of_type_Ruj = paramruj;
  }
  
  public void a(ruk paramruk)
  {
    this.jdField_a_of_type_Ruk = paramruk;
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = ((Integer)bgmq.a("readinjoy_font_size_index_sp" + obz.a(), Integer.valueOf(2))).intValue();
    }
    this.jdField_a_of_type_Qno = new qnq(this.jdField_a_of_type_AndroidAppActivity.getLayoutInflater()).a(this.jdField_a_of_type_Bemt).a(this.jdField_a_of_type_Int).a().a(this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView());
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Qno != null) && (this.jdField_a_of_type_Qno.a()))
    {
      this.jdField_a_of_type_Qno.b();
      return true;
    }
    return false;
  }
  
  public List<bahx>[] a(List<Integer>[] paramArrayOfList, ruo paramruo)
  {
    ArrayList localArrayList1 = new ArrayList();
    int j = paramArrayOfList.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramArrayOfList[i];
      ArrayList localArrayList2 = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a(localArrayList2, ((Integer)((Iterator)localObject).next()).intValue(), paramruo);
      }
      localArrayList1.add(localArrayList2);
      i += 1;
    }
    return (List[])localArrayList1.toArray(new ArrayList[localArrayList1.size()]);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Rvs != null) {
      this.jdField_a_of_type_Rvs.a();
    }
    if (this.jdField_a_of_type_Qno != null) {
      this.jdField_a_of_type_Qno.a();
    }
    this.jdField_a_of_type_Befq.removeCallbacksAndMessages(null);
    a();
  }
  
  public void b(String paramString)
  {
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.putExtra("normal", true);
    paramString.putExtra("big_brother_source_key", obz.f(0));
    try
    {
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
      return;
    }
    catch (ActivityNotFoundException paramString)
    {
      vvp.a(1, 2131629891);
    }
  }
  
  public void c()
  {
    View localView = this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView();
    localView.buildDrawingCache();
    Bitmap localBitmap1 = localView.getDrawingCache();
    if (localBitmap1 != null)
    {
      Bitmap localBitmap2 = rbb.a(this.jdField_a_of_type_AndroidAppActivity.getWindow(), localBitmap1);
      if (localBitmap2 != null)
      {
        bbmy.a(BaseApplicationImpl.getContext(), 0, 2131629909, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131167766));
        ThreadManager.executeOnFileThread(new ReadInJoyShareHelper.3(this, localBitmap2));
      }
      localBitmap1.recycle();
    }
    localView.destroyDrawingCache();
  }
  
  public void c(String paramString)
  {
    ((ClipboardManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("clipboard")).setText(paramString);
    vvp.a(2, 2131625733);
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_Rvs.a(paramString);
  }
  
  public void e(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      vvp.a(1, 2131629912);
      return;
    }
    paramString = EditPicActivity.a(this.jdField_a_of_type_AndroidAppActivity, paramString, true, true, true, true, true, 4);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (paramMessage.obj != null) {
        e((String)paramMessage.obj);
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    boolean bool;
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder().append("onItemClick, tag = ");
      if (paramAdapterView != null)
      {
        bool = true;
        QLog.d("ReadInJoyShareHelper", 2, bool);
      }
    }
    else
    {
      if (paramAdapterView != null) {
        break label59;
      }
    }
    label59:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        this.jdField_a_of_type_Bahv.b();
        paramAdapterView = (rum)((baia)paramAdapterView).a;
        paramInt = paramAdapterView.c;
      } while (this.jdField_a_of_type_Ruj == null);
      if (paramAdapterView.a)
      {
        this.jdField_a_of_type_Ruj.a(Integer.valueOf(paramInt));
        return;
      }
      paramAdapterView = this.jdField_a_of_type_Rul.a(paramInt);
    } while (paramAdapterView == null);
    this.jdField_a_of_type_Ruj.a(paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rug
 * JD-Core Version:    0.7.0.1
 */