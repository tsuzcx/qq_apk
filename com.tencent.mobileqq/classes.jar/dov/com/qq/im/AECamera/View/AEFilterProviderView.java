package dov.com.qq.im.AECamera.View;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import bgxb;
import bgzj;
import bgzl;
import bhcm;
import bhey;
import bhfm;
import bhgs;
import bhgv;
import bhgw;
import bhhh;
import bhhk;
import bhhr;
import bhiu;
import bhlf;
import bhpp;
import bjac;
import bjad;
import bjae;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.view.ProviderView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AEFilterProviderView
  extends ProviderView
  implements bgzl, bhgv
{
  public int a;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private bgzj jdField_a_of_type_Bgzj;
  private bhgs jdField_a_of_type_Bhgs;
  public bjae a;
  private AEProviderContainerView jdField_a_of_type_DovComQqImAECameraViewAEProviderContainerView;
  public ArrayList<FilterCategory> a;
  
  public AEFilterProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  public static String a()
  {
    String str = bgxb.a().a("ae_filter_id", "", 0);
    if (QLog.isColorLevel()) {
      QLog.d("AEFilterProviderView", 2, "getFilterId(ae_filter_id, " + str + ")");
    }
    return str;
  }
  
  public static void a(String paramString)
  {
    bgxb.a().a("ae_filter_id", paramString, 0);
    if (QLog.isColorLevel()) {
      QLog.d("AEFilterProviderView", 2, "saveFilterPref(ae_filter_id, " + paramString + ")");
    }
  }
  
  private void c(Bundle paramBundle)
  {
    Bundle localBundle = null;
    if (paramBundle != null) {
      localBundle = paramBundle.getBundle(AEFilterProviderView.class.getSimpleName());
    }
    if (localBundle != null)
    {
      if (bjac.a().a[this.g] != null) {
        bjac.a().a[this.g].c = 1;
      }
      paramBundle = (QIMFilterCategoryItem)localBundle.getParcelable("selected_filter_item");
      if (paramBundle != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AEFilterProviderView", 2, "restore " + paramBundle.a);
        }
        paramBundle.c = 1;
      }
    }
  }
  
  public int a()
  {
    return 2131494987;
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    QIMFilterCategoryItem localQIMFilterCategoryItem1 = bjac.a().b(this.g);
    if (localQIMFilterCategoryItem1 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AEFilterProviderView", 2, "save " + localQIMFilterCategoryItem1.a);
      }
      localBundle.putParcelable("selected_filter_item", localQIMFilterCategoryItem1);
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        FilterCategory localFilterCategory = (FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
        if (localFilterCategory != null)
        {
          Object localObject = localFilterCategory.a;
          if (localObject != null)
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              QIMFilterCategoryItem localQIMFilterCategoryItem2 = (QIMFilterCategoryItem)((Iterator)localObject).next();
              if ((localQIMFilterCategoryItem1.a() == localQIMFilterCategoryItem2.a()) && (localQIMFilterCategoryItem1.b != null) && (localQIMFilterCategoryItem1.b.equals(localQIMFilterCategoryItem2.b))) {
                localBundle.putParcelable("ProviderView.select_item_category", localFilterCategory);
              }
            }
          }
        }
      }
    }
    return localBundle;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Bhgs != null)
    {
      this.jdField_a_of_type_Bhgs.jdField_a_of_type_ArrayOfBhgw[this.g].a();
      this.jdField_a_of_type_Bhgs.b(this);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AEFilterProviderView", 2, "onDestroy");
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEFilterProviderView", 2, "category= " + paramInt + " categoryName= " + paramString1 + ",itemId=" + paramString2);
    }
    FilterCategory localFilterCategory = (FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
    paramInt = 0;
    if (paramInt < localFilterCategory.a.size())
    {
      paramString1 = (QIMFilterCategoryItem)localFilterCategory.a.get(paramInt);
      if (!paramString1.a.equals(paramString2)) {}
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AEFilterProviderView", 2, "itemInfo= " + paramString1 + ",index=" + this.jdField_a_of_type_Int + ",pos=" + paramInt);
      }
      if (paramString1 != null)
      {
        postDelayed(new AEFilterProviderView.1(this, paramInt), 200L);
        if (this.jdField_a_of_type_Bhgs != null)
        {
          paramString2 = new Bundle();
          paramString2.putInt("apply_source", 1);
          paramString2.putInt("capture_scene", this.g);
          this.jdField_a_of_type_Bhgs.a(paramString1, (Activity)getContext(), paramString2);
        }
        if (!this.jdField_a_of_type_DovComQqImAECameraViewAEProviderContainerView.a()) {
          a(paramString1.a);
        }
        this.jdField_a_of_type_Bgzj.notifyDataSetChanged();
      }
      return;
      paramInt += 1;
      break;
      paramInt = 0;
      paramString1 = null;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_DovComQqImAECameraViewAEProviderContainerView = ((AEProviderContainerView)((Activity)getContext()).findViewById(2131297572));
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131492938, this, true);
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300661));
    paramBundle = new LinearLayoutManager(this.jdField_a_of_type_AndroidContentContext, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramBundle);
    this.jdField_a_of_type_Bgzj = new bgzj(this.jdField_a_of_type_AndroidContentContext, this.g);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bgzj);
    this.jdField_a_of_type_Bgzj.a(this);
    if (bhfm.a().a(5))
    {
      this.jdField_a_of_type_Bhgs = ((bhgs)bhfm.a(5));
      if (this.jdField_a_of_type_Bhgs != null) {
        this.jdField_a_of_type_Bhgs.a(this);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "FilterProviderView onCreate");
    }
    paramBundle = this.jdField_a_of_type_Bhgs.jdField_a_of_type_Bjad;
    if (paramBundle == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AEFilterProviderView", 2, "filterProviderView get data is null");
      }
      return;
    }
    a(paramBundle.a(this.g));
  }
  
  public void a(View paramView, int paramInt)
  {
    StringBuilder localStringBuilder = null;
    if (paramView != null) {}
    for (Object localObject = paramView.getTag();; localObject = null)
    {
      paramView = localStringBuilder;
      if (localObject != null) {
        paramView = (QIMFilterCategoryItem)localObject;
      }
      if (paramView == null) {
        return;
      }
      if (paramView != null)
      {
        if (paramInt != 0) {
          break label230;
        }
        bhcm.a().g("none");
        label46:
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("report filter click(").append(paramInt).append(", ");
          if (paramInt != 0) {
            break label243;
          }
        }
      }
      label230:
      label243:
      for (localObject = "none";; localObject = "" + paramView.a)
      {
        QLog.d("AEFilterProviderView", 2, (String)localObject + ")");
        if (this.jdField_a_of_type_Bhpp != null) {
          this.jdField_a_of_type_Bhpp.a(-1, paramView);
        }
        if (this.jdField_a_of_type_Bhgs != null)
        {
          localObject = new Bundle();
          ((Bundle)localObject).putInt("apply_source", 1);
          ((Bundle)localObject).putInt("capture_scene", this.g);
          this.jdField_a_of_type_Bhgs.a(paramView, (Activity)getContext(), (Bundle)localObject);
        }
        if (!this.jdField_a_of_type_DovComQqImAECameraViewAEProviderContainerView.a()) {
          a(paramView.a);
        }
        ((bhlf)bhfm.a(14)).a(paramView.b, 1);
        if (this.jdField_a_of_type_Bhgs == null) {
          break;
        }
        this.jdField_a_of_type_Bhgs.a(this.g, (Activity)this.jdField_a_of_type_AndroidContentContext);
        return;
        bhcm.a().g(paramView.a);
        break label46;
      }
    }
  }
  
  public void a(bhhh parambhhh) {}
  
  public void a(bhhh parambhhh, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "fp onComboApply combo " + parambhhh.a + " filter ");
    }
    this.jdField_a_of_type_Bgzj.notifyDataSetChanged();
  }
  
  public void a(bhhk parambhhk, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_Bgzj.notifyDataSetChanged();
    if (paramBoolean)
    {
      parambhhk = (bhiu)bhfm.a().c(8);
      if (this.g != 0) {
        break label44;
      }
    }
    label44:
    for (paramInt = bhey.b;; paramInt = bhey.c)
    {
      parambhhk.d(paramInt);
      parambhhk.f();
      return;
    }
  }
  
  public void a(bhhr parambhhr, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(bjad parambjad)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onComboFilterDataUpdated data:");
      if (parambjad != null) {
        break label57;
      }
    }
    label57:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("AEFilterProviderView", 2, bool);
      if (parambjad != null) {
        a(parambjad.a(this.g));
      }
      return;
    }
  }
  
  public void a(bjae parambjae)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEFilterProviderView", 2, "filters setup()");
    }
    this.jdField_a_of_type_Bjae = parambjae;
    this.jdField_a_of_type_JavaUtilArrayList = parambjae.jdField_b_of_type_JavaUtilArrayList;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > this.jdField_a_of_type_Int)) {
      this.jdField_a_of_type_Bgzj.a(((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a);
    }
    this.jdField_a_of_type_Bgzj.notifyDataSetChanged();
  }
  
  public void b()
  {
    super.b();
    Object localObject;
    if ((this.jdField_a_of_type_Bjae == null) && (this.jdField_a_of_type_Bhgs != null))
    {
      localObject = this.jdField_a_of_type_Bhgs.jdField_a_of_type_Bjad;
      if (localObject != null) {
        this.jdField_a_of_type_Bjae = ((bjad)localObject).a(this.g);
      }
    }
    if ((this.jdField_a_of_type_Bjae != null) && (this.jdField_a_of_type_Bjae.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem != null))
    {
      localObject = (Activity)getContext();
      this.jdField_a_of_type_Bhgs.a(this.jdField_a_of_type_Bjae.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem).a((Activity)localObject, this.g);
      bjac.a().b(this.jdField_a_of_type_Bjae.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem, (Activity)getContext(), this.g);
      bjac.a().a(this.jdField_a_of_type_Bjae.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem, this.g);
      this.jdField_a_of_type_Bgzj.notifyDataSetChanged();
      a(null, 0);
    }
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    c(paramBundle);
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Bhpp != null) {
      this.jdField_a_of_type_Bhpp.i();
    }
    this.jdField_a_of_type_Bgzj.notifyDataSetChanged();
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Bhpp != null) {
      this.jdField_a_of_type_Bhpp.b(false);
    }
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_Bhgs != null) {
      this.jdField_a_of_type_Bhgs.a(this);
    }
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_Bhgs != null) {
      this.jdField_a_of_type_Bhgs.b(this);
    }
  }
  
  public void setFilterItemBorderMode(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bgzj != null) {
      this.jdField_a_of_type_Bgzj.a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AECamera.View.AEFilterProviderView
 * JD-Core Version:    0.7.0.1
 */