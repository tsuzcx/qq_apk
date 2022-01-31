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

public class sgy
  implements Handler.Callback, AdapterView.OnItemClickListener
{
  private int jdField_a_of_type_Int = -1;
  public Activity a;
  public bbjc a;
  private bfnk jdField_a_of_type_Bfnk;
  private bfun jdField_a_of_type_Bfun = new sha(this);
  private qzx jdField_a_of_type_Qzx;
  private sel jdField_a_of_type_Sel;
  private shb jdField_a_of_type_Shb;
  private shc jdField_a_of_type_Shc;
  protected shd a;
  private sik jdField_a_of_type_Sik;
  
  public sgy() {}
  
  public sgy(Activity paramActivity, AppInterface paramAppInterface, shd paramshd, shb paramshb)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Shd = paramshd;
    if (this.jdField_a_of_type_Shd == null) {
      this.jdField_a_of_type_Shd = new shd();
    }
    this.jdField_a_of_type_Shb = paramshb;
    if (this.jdField_a_of_type_Bbjc == null) {
      this.jdField_a_of_type_Bbjc = new bbjc(this.jdField_a_of_type_AndroidAppActivity);
    }
    this.jdField_a_of_type_Sik = new sik(paramAppInterface);
    this.jdField_a_of_type_Bfnk = new bfnk(this);
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
  
  private boolean a(ArrayList<bbje> paramArrayList, int paramInt, shg paramshg)
  {
    if (paramshg != null)
    {
      paramshg = paramshg.a(Integer.valueOf(paramInt));
      if (paramshg != null)
      {
        paramArrayList.add(paramshg);
        return true;
      }
    }
    return false;
  }
  
  public bbjc a(List<Integer>[] paramArrayOfList)
  {
    this.jdField_a_of_type_Bbjc.a(a(paramArrayOfList, this.jdField_a_of_type_Shd));
    this.jdField_a_of_type_Bbjc.a(this);
    this.jdField_a_of_type_Bbjc.a();
    return this.jdField_a_of_type_Bbjc;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bbjc.a()) {
      this.jdField_a_of_type_Bbjc.b();
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Sel == null) {
      this.jdField_a_of_type_Sel = new sel(this.jdField_a_of_type_AndroidAppActivity, new sgz(this));
    }
    this.jdField_a_of_type_Sel.a(paramString);
  }
  
  public void a(shb paramshb)
  {
    this.jdField_a_of_type_Shb = paramshb;
  }
  
  public void a(shc paramshc)
  {
    this.jdField_a_of_type_Shc = paramshc;
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = ((Integer)bhvh.a("readinjoy_font_size_index_sp" + onk.a(), Integer.valueOf(2))).intValue();
    }
    this.jdField_a_of_type_Qzx = new qzz(this.jdField_a_of_type_AndroidAppActivity.getLayoutInflater()).a(this.jdField_a_of_type_Bfun).a(this.jdField_a_of_type_Int).a().a(this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView());
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Qzx != null) && (this.jdField_a_of_type_Qzx.a()))
    {
      this.jdField_a_of_type_Qzx.b();
      return true;
    }
    return false;
  }
  
  public List<bbje>[] a(List<Integer>[] paramArrayOfList, shg paramshg)
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
        a(localArrayList2, ((Integer)((Iterator)localObject).next()).intValue(), paramshg);
      }
      localArrayList1.add(localArrayList2);
      i += 1;
    }
    return (List[])localArrayList1.toArray(new ArrayList[localArrayList1.size()]);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Sik != null) {
      this.jdField_a_of_type_Sik.a();
    }
    if (this.jdField_a_of_type_Qzx != null) {
      this.jdField_a_of_type_Qzx.a();
    }
    this.jdField_a_of_type_Bfnk.removeCallbacksAndMessages(null);
    a();
  }
  
  public void b(String paramString)
  {
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.putExtra("normal", true);
    paramString.putExtra("big_brother_source_key", onk.f(0));
    try
    {
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
      return;
    }
    catch (ActivityNotFoundException paramString)
    {
      wim.a(1, 2131695572);
    }
  }
  
  public void c()
  {
    View localView = this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView();
    localView.buildDrawingCache();
    Bitmap localBitmap1 = localView.getDrawingCache();
    if (localBitmap1 != null)
    {
      Bitmap localBitmap2 = rnt.a(this.jdField_a_of_type_AndroidAppActivity.getWindow(), localBitmap1);
      if (localBitmap2 != null)
      {
        bcpw.a(BaseApplicationImpl.getContext(), 0, 2131695590, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298865));
        ThreadManager.executeOnFileThread(new ReadInJoyShareHelper.3(this, localBitmap2));
      }
      localBitmap1.recycle();
    }
    localView.destroyDrawingCache();
  }
  
  public void c(String paramString)
  {
    ((ClipboardManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("clipboard")).setText(paramString);
    wim.a(2, 2131691309);
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_Sik.a(paramString);
  }
  
  public void e(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      wim.a(1, 2131695593);
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
        this.jdField_a_of_type_Bbjc.b();
        paramAdapterView = (she)((bbjh)paramAdapterView).a;
        paramInt = paramAdapterView.c;
      } while (this.jdField_a_of_type_Shb == null);
      if (paramAdapterView.a)
      {
        this.jdField_a_of_type_Shb.a(Integer.valueOf(paramInt));
        return;
      }
      paramAdapterView = this.jdField_a_of_type_Shd.a(paramInt);
    } while (paramAdapterView == null);
    this.jdField_a_of_type_Shb.a(paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sgy
 * JD-Core Version:    0.7.0.1
 */