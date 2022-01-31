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

public class sgv
  implements Handler.Callback, AdapterView.OnItemClickListener
{
  private int jdField_a_of_type_Int = -1;
  public Activity a;
  public bbjq a;
  private bfob jdField_a_of_type_Bfob;
  private bfve jdField_a_of_type_Bfve = new sgx(this);
  private qzu jdField_a_of_type_Qzu;
  private sei jdField_a_of_type_Sei;
  private sgy jdField_a_of_type_Sgy;
  private sgz jdField_a_of_type_Sgz;
  protected sha a;
  private sih jdField_a_of_type_Sih;
  
  public sgv() {}
  
  public sgv(Activity paramActivity, AppInterface paramAppInterface, sha paramsha, sgy paramsgy)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Sha = paramsha;
    if (this.jdField_a_of_type_Sha == null) {
      this.jdField_a_of_type_Sha = new sha();
    }
    this.jdField_a_of_type_Sgy = paramsgy;
    if (this.jdField_a_of_type_Bbjq == null) {
      this.jdField_a_of_type_Bbjq = new bbjq(this.jdField_a_of_type_AndroidAppActivity);
    }
    this.jdField_a_of_type_Sih = new sih(paramAppInterface);
    this.jdField_a_of_type_Bfob = new bfob(this);
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
  
  private boolean a(ArrayList<bbjs> paramArrayList, int paramInt, shd paramshd)
  {
    if (paramshd != null)
    {
      paramshd = paramshd.a(Integer.valueOf(paramInt));
      if (paramshd != null)
      {
        paramArrayList.add(paramshd);
        return true;
      }
    }
    return false;
  }
  
  public bbjq a(List<Integer>[] paramArrayOfList)
  {
    this.jdField_a_of_type_Bbjq.a(a(paramArrayOfList, this.jdField_a_of_type_Sha));
    this.jdField_a_of_type_Bbjq.a(this);
    this.jdField_a_of_type_Bbjq.a();
    return this.jdField_a_of_type_Bbjq;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bbjq.a()) {
      this.jdField_a_of_type_Bbjq.b();
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Sei == null) {
      this.jdField_a_of_type_Sei = new sei(this.jdField_a_of_type_AndroidAppActivity, new sgw(this));
    }
    this.jdField_a_of_type_Sei.a(paramString);
  }
  
  public void a(sgy paramsgy)
  {
    this.jdField_a_of_type_Sgy = paramsgy;
  }
  
  public void a(sgz paramsgz)
  {
    this.jdField_a_of_type_Sgz = paramsgz;
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = ((Integer)bhvy.a("readinjoy_font_size_index_sp" + onh.a(), Integer.valueOf(2))).intValue();
    }
    this.jdField_a_of_type_Qzu = new qzw(this.jdField_a_of_type_AndroidAppActivity.getLayoutInflater()).a(this.jdField_a_of_type_Bfve).a(this.jdField_a_of_type_Int).a().a(this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView());
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Qzu != null) && (this.jdField_a_of_type_Qzu.a()))
    {
      this.jdField_a_of_type_Qzu.b();
      return true;
    }
    return false;
  }
  
  public List<bbjs>[] a(List<Integer>[] paramArrayOfList, shd paramshd)
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
        a(localArrayList2, ((Integer)((Iterator)localObject).next()).intValue(), paramshd);
      }
      localArrayList1.add(localArrayList2);
      i += 1;
    }
    return (List[])localArrayList1.toArray(new ArrayList[localArrayList1.size()]);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Sih != null) {
      this.jdField_a_of_type_Sih.a();
    }
    if (this.jdField_a_of_type_Qzu != null) {
      this.jdField_a_of_type_Qzu.a();
    }
    this.jdField_a_of_type_Bfob.removeCallbacksAndMessages(null);
    a();
  }
  
  public void b(String paramString)
  {
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.putExtra("normal", true);
    paramString.putExtra("big_brother_source_key", onh.f(0));
    try
    {
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
      return;
    }
    catch (ActivityNotFoundException paramString)
    {
      wij.a(1, 2131695573);
    }
  }
  
  public void c()
  {
    View localView = this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView();
    localView.buildDrawingCache();
    Bitmap localBitmap1 = localView.getDrawingCache();
    if (localBitmap1 != null)
    {
      Bitmap localBitmap2 = rnq.a(this.jdField_a_of_type_AndroidAppActivity.getWindow(), localBitmap1);
      if (localBitmap2 != null)
      {
        bcql.a(BaseApplicationImpl.getContext(), 0, 2131695591, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298865));
        ThreadManager.executeOnFileThread(new ReadInJoyShareHelper.3(this, localBitmap2));
      }
      localBitmap1.recycle();
    }
    localView.destroyDrawingCache();
  }
  
  public void c(String paramString)
  {
    ((ClipboardManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("clipboard")).setText(paramString);
    wij.a(2, 2131691309);
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_Sih.a(paramString);
  }
  
  public void e(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      wij.a(1, 2131695594);
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
        this.jdField_a_of_type_Bbjq.b();
        paramAdapterView = (shb)((bbjv)paramAdapterView).a;
        paramInt = paramAdapterView.c;
      } while (this.jdField_a_of_type_Sgy == null);
      if (paramAdapterView.a)
      {
        this.jdField_a_of_type_Sgy.a(Integer.valueOf(paramInt));
        return;
      }
      paramAdapterView = this.jdField_a_of_type_Sha.a(paramInt);
    } while (paramAdapterView == null);
    this.jdField_a_of_type_Sgy.a(paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sgv
 * JD-Core Version:    0.7.0.1
 */