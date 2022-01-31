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
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class syq
  implements Handler.Callback, AdapterView.OnItemClickListener
{
  private int jdField_a_of_type_Int = -1;
  public Activity a;
  private bhtd jdField_a_of_type_Bhtd;
  private biai jdField_a_of_type_Biai = new sys(this);
  public ShareActionSheetBuilder a;
  private rpq jdField_a_of_type_Rpq;
  private swc jdField_a_of_type_Swc;
  private syt jdField_a_of_type_Syt;
  private syu jdField_a_of_type_Syu;
  protected syv a;
  private tac jdField_a_of_type_Tac;
  
  public syq() {}
  
  public syq(Activity paramActivity, AppInterface paramAppInterface, syv paramsyv, syt paramsyt)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Syv = paramsyv;
    if (this.jdField_a_of_type_Syv == null) {
      this.jdField_a_of_type_Syv = new syv();
    }
    this.jdField_a_of_type_Syt = paramsyt;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new stb(this.jdField_a_of_type_AndroidAppActivity);
    }
    this.jdField_a_of_type_Tac = new tac(paramAppInterface);
    this.jdField_a_of_type_Bhtd = new bhtd(this);
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
  
  private boolean a(ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList, int paramInt, syy paramsyy)
  {
    if (paramsyy != null)
    {
      paramsyy = paramsyy.a(Integer.valueOf(paramInt));
      if (paramsyy != null)
      {
        paramArrayList.add(paramsyy);
        return true;
      }
    }
    return false;
  }
  
  public ShareActionSheetBuilder a(List<Integer>[] paramArrayOfList)
  {
    a(paramArrayOfList, false);
    return this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder;
  }
  
  public ShareActionSheetBuilder a(List<Integer>[] paramArrayOfList, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a(paramArrayOfList, this.jdField_a_of_type_Syv));
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(this);
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder instanceof stb)) {
      ((stb)this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder).a(paramBoolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
    return this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Swc == null) {
      this.jdField_a_of_type_Swc = new swc(this.jdField_a_of_type_AndroidAppActivity, new syr(this));
    }
    this.jdField_a_of_type_Swc.a(paramString);
  }
  
  public void a(syt paramsyt)
  {
    this.jdField_a_of_type_Syt = paramsyt;
  }
  
  public void a(syu paramsyu)
  {
    this.jdField_a_of_type_Syu = paramsyu;
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = ((Integer)bkbq.a("readinjoy_font_size_index_sp" + ors.a(), Integer.valueOf(2))).intValue();
    }
    this.jdField_a_of_type_Rpq = new rps(this.jdField_a_of_type_AndroidAppActivity.getLayoutInflater()).a(this.jdField_a_of_type_Biai).a(this.jdField_a_of_type_Int).a().a(this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView());
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Rpq != null) && (this.jdField_a_of_type_Rpq.a()))
    {
      this.jdField_a_of_type_Rpq.b();
      return true;
    }
    return false;
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a(List<Integer>[] paramArrayOfList, syy paramsyy)
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
        a(localArrayList2, ((Integer)((Iterator)localObject).next()).intValue(), paramsyy);
      }
      localArrayList1.add(localArrayList2);
      i += 1;
    }
    return (List[])localArrayList1.toArray(new ArrayList[localArrayList1.size()]);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Tac != null) {
      this.jdField_a_of_type_Tac.a();
    }
    if (this.jdField_a_of_type_Rpq != null) {
      this.jdField_a_of_type_Rpq.a();
    }
    this.jdField_a_of_type_Bhtd.removeCallbacksAndMessages(null);
    a();
  }
  
  public void b(String paramString)
  {
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.putExtra("normal", true);
    paramString.putExtra("big_brother_source_key", ors.f(0));
    try
    {
      this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
      return;
    }
    catch (ActivityNotFoundException paramString)
    {
      ybk.a(1, 2131695733);
    }
  }
  
  public void c()
  {
    View localView = this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView();
    localView.buildDrawingCache();
    Bitmap localBitmap1 = localView.getDrawingCache();
    if (localBitmap1 != null)
    {
      Bitmap localBitmap2 = sdp.a(this.jdField_a_of_type_AndroidAppActivity.getWindow(), localBitmap1);
      if (localBitmap2 != null)
      {
        QQToast.a(BaseApplicationImpl.getContext(), 0, 2131695751, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298914));
        ThreadManager.executeOnFileThread(new ReadInJoyShareHelper.3(this, localBitmap2));
      }
      localBitmap1.recycle();
    }
    localView.destroyDrawingCache();
  }
  
  public void c(String paramString)
  {
    ((ClipboardManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("clipboard")).setText(paramString);
    ybk.a(2, 2131691363);
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_Tac.a(paramString);
  }
  
  public void e(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ybk.a(1, 2131695754);
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
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
        paramAdapterView = (syw)((bdmy)paramAdapterView).a;
        paramInt = paramAdapterView.action;
      } while (this.jdField_a_of_type_Syt == null);
      if (paramAdapterView.a)
      {
        this.jdField_a_of_type_Syt.a(Integer.valueOf(paramInt));
        return;
      }
      paramAdapterView = this.jdField_a_of_type_Syv.a(paramInt);
    } while (paramAdapterView == null);
    this.jdField_a_of_type_Syt.a(paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     syq
 * JD-Core Version:    0.7.0.1
 */