package dov.com.qq.im.ae.play;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import bdkf;
import bkle;
import bkvu;
import blbm;
import blbs;
import blbv;
import blca;
import blcb;
import blen;
import bler;
import blfg;
import java.util.List;

public class AEPlayShowPageView
  extends FrameLayout
{
  private static final blbv jdField_a_of_type_Blbv = a(1);
  private static final blbv b = a(2);
  private int jdField_a_of_type_Int = 2;
  private GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private blbm jdField_a_of_type_Blbm;
  private blbs jdField_a_of_type_Blbs;
  private List<bkvu> jdField_a_of_type_JavaUtilList;
  
  public AEPlayShowPageView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, @NonNull blbm paramblbm, int paramInt2, @NonNull List<bkvu> paramList)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    a(paramblbm, paramInt2, paramList);
    a(paramContext);
  }
  
  public AEPlayShowPageView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @NonNull blbm paramblbm, int paramInt, @NonNull List<bkvu> paramList)
  {
    this(paramContext, paramAttributeSet, 0, paramblbm, paramInt, paramList);
  }
  
  public AEPlayShowPageView(@NonNull Context paramContext, @NonNull blbm paramblbm, int paramInt, @NonNull List<bkvu> paramList)
  {
    this(paramContext, null, paramblbm, paramInt, paramList);
  }
  
  private static blbv a(int paramInt)
  {
    int j = bdkf.a(10.0F);
    int k = bdkf.a(4.0F);
    int m = (int)(k * 0.96F);
    if (paramInt == 1) {}
    for (int i = bdkf.a() - j * 2 - k * 2;; i = (bdkf.a() - j * 2 - k * 4) / 2)
    {
      int n = (int)(i * 0.96F * 59.0F / 34.0F);
      blbv localblbv = new blbv();
      localblbv.jdField_a_of_type_Int = (i + k * 2);
      localblbv.b = (m * 2 + n);
      localblbv.c = k;
      localblbv.d = m;
      if (paramInt == 1) {
        localblbv.d = j;
      }
      return localblbv;
    }
  }
  
  private void a(@NonNull Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131558521, this, true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131362192));
    blfg.a("AEPlayShowPart", "rv toString " + this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.toString());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new blca(this));
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(paramContext, 1, 1, false);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
      if (this.jdField_a_of_type_Int != 1) {
        break label198;
      }
    }
    label198:
    for (blbv localblbv = new blbv(jdField_a_of_type_Blbv);; localblbv = new blbv(b))
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new blcb(this, localblbv));
      this.jdField_a_of_type_Blbs = new blbs(paramContext, this.jdField_a_of_type_Blbm, localblbv, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Blbs);
      a(this.jdField_a_of_type_JavaUtilList);
      return;
      this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(paramContext, 2, 1, false);
      break;
    }
  }
  
  private void a(@NonNull blbm paramblbm, int paramInt, @NonNull List<bkvu> paramList)
  {
    this.jdField_a_of_type_Blbm = paramblbm;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Blbm == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_Blbm.a(65537, new Object[0]);
      } while (!(localObject instanceof bkle));
      localObject = (bkle)localObject;
    } while ((((bkle)localObject).a() == null) || (((bkle)localObject).a().getIntent() == null));
    ((bkle)localObject).a().getIntent().putExtra("KEY_CURRENT_SELECT_ID", "");
    ((bkle)localObject).a().getIntent().putExtra("KEY_CURRENT_TYPE", "");
  }
  
  public void a()
  {
    this.jdField_a_of_type_Blbs.a();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager != null) {
        this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.scrollToPositionWithOffset(paramInt, 0);
      }
      blfg.a("AEPlayShowPart", "out........" + this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.toString());
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.post(new AEPlayShowPageView.3(this, paramInt));
    }
  }
  
  public void a(@NonNull List<bkvu> paramList)
  {
    if (this.jdField_a_of_type_Blbs != null) {
      this.jdField_a_of_type_Blbs.a(paramList);
    }
  }
  
  public void b()
  {
    int i = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
    int j = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findLastVisibleItemPosition();
    if ((this.jdField_a_of_type_JavaUtilList == null) || (i < 0) || (j < 0)) {}
    for (;;)
    {
      return;
      while ((i < this.jdField_a_of_type_JavaUtilList.size()) && (i <= j))
      {
        bkvu localbkvu = (bkvu)this.jdField_a_of_type_JavaUtilList.get(i);
        bler.a().c(localbkvu.f);
        bler.a().b(i + 1);
        blen.a().f(localbkvu.a);
        i += 1;
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.scrollTo(0, paramInt);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.removeCallbacks(null);
    }
    if (this.jdField_a_of_type_Blbs != null) {
      this.jdField_a_of_type_Blbs.b();
    }
  }
  
  public void setTabId(String paramString)
  {
    this.jdField_a_of_type_Blbs.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowPageView
 * JD-Core Version:    0.7.0.1
 */