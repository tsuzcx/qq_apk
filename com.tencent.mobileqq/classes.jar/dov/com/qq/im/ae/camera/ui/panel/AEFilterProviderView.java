package dov.com.qq.im.ae.camera.ui.panel;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import bkka;
import bkou;
import bkov;
import bkta;
import bktc;
import bler;
import blev;
import blmf;
import blnl;
import blno;
import blnp;
import blob;
import bloe;
import blol;
import blpo;
import blrz;
import blwi;
import bncp;
import bncq;
import bncr;
import com.tencent.aekit.api.standard.filter.AESticker;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.view.ProviderView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AEFilterProviderView
  extends ProviderView
  implements bktc, blno
{
  public int a;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private bkta jdField_a_of_type_Bkta;
  private blnl jdField_a_of_type_Blnl;
  public bncr a;
  private AEProviderContainerView jdField_a_of_type_DovComQqImAeCameraUiPanelAEProviderContainerView;
  public ArrayList<FilterCategory> a;
  
  public AEFilterProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  public static String a()
  {
    String str = blev.a().a("ae_filter_id", "", 0);
    if (QLog.isColorLevel()) {
      QLog.d("AEFilterProviderView", 2, "getFilterId(ae_filter_id, " + str + ")");
    }
    return str;
  }
  
  public static void a(String paramString)
  {
    blev.a().a("ae_filter_id", paramString, 0);
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
      if (bncp.a().a[this.g] != null) {
        bncp.a().a[this.g].c = 1;
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
    return 2131560736;
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    QIMFilterCategoryItem localQIMFilterCategoryItem1 = bncp.a().b(this.g);
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
    if (this.jdField_a_of_type_Blnl != null)
    {
      this.jdField_a_of_type_Blnl.jdField_a_of_type_ArrayOfBlnp[this.g].a();
      this.jdField_a_of_type_Blnl.b(this);
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
        if (this.jdField_a_of_type_Blnl != null)
        {
          paramString2 = new Bundle();
          paramString2.putInt("apply_source", 1);
          paramString2.putInt("capture_scene", this.g);
          this.jdField_a_of_type_Blnl.a(paramString1, (Activity)getContext(), paramString2);
        }
        if (!this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEProviderContainerView.a()) {
          a(paramString1.a);
        }
        this.jdField_a_of_type_Bkta.notifyDataSetChanged();
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
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEProviderContainerView = ((AEProviderContainerView)((Activity)getContext()).findViewById(2131363158));
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131558478, this, true);
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366354));
    paramBundle = new LinearLayoutManager(this.jdField_a_of_type_AndroidContentContext, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramBundle);
    this.jdField_a_of_type_Bkta = new bkta(this.jdField_a_of_type_AndroidContentContext, this.g);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bkta);
    this.jdField_a_of_type_Bkta.a(this);
    if (blmf.a().a(5))
    {
      this.jdField_a_of_type_Blnl = ((blnl)blmf.a(5));
      if (this.jdField_a_of_type_Blnl != null) {
        this.jdField_a_of_type_Blnl.a(this);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "FilterProviderView onCreate");
    }
    paramBundle = this.jdField_a_of_type_Blnl.jdField_a_of_type_Bncq;
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
          break label265;
        }
        bler.a().h("none");
        label46:
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("report filter click(").append(paramInt).append(", ");
          if (paramInt != 0) {
            break label278;
          }
        }
      }
      label265:
      label278:
      for (localObject = "none";; localObject = "" + paramView.a)
      {
        QLog.d("AEFilterProviderView", 2, (String)localObject + ")");
        if (this.jdField_a_of_type_Blwi != null) {
          this.jdField_a_of_type_Blwi.a(-1, paramView);
        }
        if (this.jdField_a_of_type_Blnl != null)
        {
          localObject = new Bundle();
          ((Bundle)localObject).putInt("apply_source", 1);
          ((Bundle)localObject).putInt("capture_scene", this.g);
          if ((bkou.a() != null) && (bkou.a().a() != null) && (bkou.a().a().isExcludeOuterEffectFilterMaterial())) {
            ((Bundle)localObject).putBoolean("capture_force_enable", true);
          }
          this.jdField_a_of_type_Blnl.a(paramView, (Activity)getContext(), (Bundle)localObject);
        }
        if (!this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEProviderContainerView.a()) {
          a(paramView.a);
        }
        ((blrz)blmf.a(14)).a(paramView.b, 1);
        if (this.jdField_a_of_type_Blnl == null) {
          break;
        }
        this.jdField_a_of_type_Blnl.a(this.g, (Activity)this.jdField_a_of_type_AndroidContentContext);
        return;
        bler.a().h(paramView.a);
        break label46;
      }
    }
  }
  
  public void a(blob paramblob) {}
  
  public void a(blob paramblob, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "fp onComboApply combo " + paramblob.a + " filter ");
    }
    this.jdField_a_of_type_Bkta.notifyDataSetChanged();
  }
  
  public void a(bloe parambloe, boolean paramBoolean, int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_Bkta.notifyDataSetChanged();
    if (paramBoolean)
    {
      parambloe = (blpo)blmf.a().c(8);
      if (this.g != 0) {
        break label44;
      }
    }
    label44:
    for (paramInt = bkka.b;; paramInt = bkka.c)
    {
      parambloe.d(paramInt);
      parambloe.f();
      return;
    }
  }
  
  public void a(blol paramblol, boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void a(bncq parambncq)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onComboFilterDataUpdated data:");
      if (parambncq != null) {
        break label57;
      }
    }
    label57:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("AEFilterProviderView", 2, bool);
      if (parambncq != null) {
        a(parambncq.a(this.g));
      }
      return;
    }
  }
  
  public void a(bncr parambncr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEFilterProviderView", 2, "filters setup()");
    }
    this.jdField_a_of_type_Bncr = parambncr;
    this.jdField_a_of_type_JavaUtilArrayList = parambncr.jdField_b_of_type_JavaUtilArrayList;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > this.jdField_a_of_type_Int)) {
      this.jdField_a_of_type_Bkta.a(((FilterCategory)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).a);
    }
    this.jdField_a_of_type_Bkta.notifyDataSetChanged();
  }
  
  public void b()
  {
    super.b();
    Object localObject;
    if ((this.jdField_a_of_type_Bncr == null) && (this.jdField_a_of_type_Blnl != null))
    {
      localObject = this.jdField_a_of_type_Blnl.jdField_a_of_type_Bncq;
      if (localObject != null) {
        this.jdField_a_of_type_Bncr = ((bncq)localObject).a(this.g);
      }
    }
    if ((this.jdField_a_of_type_Bncr != null) && (this.jdField_a_of_type_Bncr.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem != null))
    {
      localObject = (Activity)getContext();
      this.jdField_a_of_type_Blnl.a(this.jdField_a_of_type_Bncr.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem).a((Activity)localObject, this.g);
      bncp.a().b(this.jdField_a_of_type_Bncr.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem, (Activity)getContext(), this.g);
      bncp.a().a(this.jdField_a_of_type_Bncr.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem, this.g);
      this.jdField_a_of_type_Bkta.notifyDataSetChanged();
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
    if (this.jdField_a_of_type_Blwi != null) {
      this.jdField_a_of_type_Blwi.i();
    }
    this.jdField_a_of_type_Bkta.notifyDataSetChanged();
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Blwi != null) {
      this.jdField_a_of_type_Blwi.b(false);
    }
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_Blnl != null) {
      this.jdField_a_of_type_Blnl.a(this);
    }
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_Blnl != null) {
      this.jdField_a_of_type_Blnl.b(this);
    }
  }
  
  public void setFilterItemBorderMode(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bkta != null) {
      this.jdField_a_of_type_Bkta.a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEFilterProviderView
 * JD-Core Version:    0.7.0.1
 */