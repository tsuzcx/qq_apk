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
import bdoo;
import bkpl;
import blab;
import blft;
import blfz;
import blgc;
import blgh;
import blgi;
import bliu;
import bliy;
import bljn;
import java.util.List;

public class AEPlayShowPageView
  extends FrameLayout
{
  private static final blgc jdField_a_of_type_Blgc = a(1);
  private static final blgc b = a(2);
  private int jdField_a_of_type_Int = 2;
  private GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private blft jdField_a_of_type_Blft;
  private blfz jdField_a_of_type_Blfz;
  private List<blab> jdField_a_of_type_JavaUtilList;
  
  public AEPlayShowPageView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, @NonNull blft paramblft, int paramInt2, @NonNull List<blab> paramList)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    a(paramblft, paramInt2, paramList);
    a(paramContext);
  }
  
  public AEPlayShowPageView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @NonNull blft paramblft, int paramInt, @NonNull List<blab> paramList)
  {
    this(paramContext, paramAttributeSet, 0, paramblft, paramInt, paramList);
  }
  
  public AEPlayShowPageView(@NonNull Context paramContext, @NonNull blft paramblft, int paramInt, @NonNull List<blab> paramList)
  {
    this(paramContext, null, paramblft, paramInt, paramList);
  }
  
  private static blgc a(int paramInt)
  {
    int j = bdoo.a(10.0F);
    int k = bdoo.a(4.0F);
    int m = (int)(k * 0.96F);
    if (paramInt == 1) {}
    for (int i = bdoo.a() - j * 2 - k * 2;; i = (bdoo.a() - j * 2 - k * 4) / 2)
    {
      int n = (int)(i * 0.96F * 59.0F / 34.0F);
      blgc localblgc = new blgc();
      localblgc.jdField_a_of_type_Int = (i + k * 2);
      localblgc.b = (m * 2 + n);
      localblgc.c = k;
      localblgc.d = m;
      if (paramInt == 1) {
        localblgc.d = j;
      }
      return localblgc;
    }
  }
  
  private void a(@NonNull Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131558521, this, true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131362192));
    bljn.a("AEPlayShowPart", "rv toString " + this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.toString());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new blgh(this));
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(paramContext, 1, 1, false);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
      if (this.jdField_a_of_type_Int != 1) {
        break label198;
      }
    }
    label198:
    for (blgc localblgc = new blgc(jdField_a_of_type_Blgc);; localblgc = new blgc(b))
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new blgi(this, localblgc));
      this.jdField_a_of_type_Blfz = new blfz(paramContext, this.jdField_a_of_type_Blft, localblgc, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Blfz);
      a(this.jdField_a_of_type_JavaUtilList);
      return;
      this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(paramContext, 2, 1, false);
      break;
    }
  }
  
  private void a(@NonNull blft paramblft, int paramInt, @NonNull List<blab> paramList)
  {
    this.jdField_a_of_type_Blft = paramblft;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Blft == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_Blft.a(65537, new Object[0]);
      } while (!(localObject instanceof bkpl));
      localObject = (bkpl)localObject;
    } while ((((bkpl)localObject).a() == null) || (((bkpl)localObject).a().getIntent() == null));
    ((bkpl)localObject).a().getIntent().putExtra("KEY_CURRENT_SELECT_ID", "");
    ((bkpl)localObject).a().getIntent().putExtra("KEY_CURRENT_TYPE", "");
  }
  
  public void a()
  {
    this.jdField_a_of_type_Blfz.a();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager != null) {
        this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.scrollToPositionWithOffset(paramInt, 0);
      }
      bljn.a("AEPlayShowPart", "out........" + this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.toString());
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.post(new AEPlayShowPageView.3(this, paramInt));
    }
  }
  
  public void a(@NonNull List<blab> paramList)
  {
    if (this.jdField_a_of_type_Blfz != null) {
      this.jdField_a_of_type_Blfz.a(paramList);
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
        blab localblab = (blab)this.jdField_a_of_type_JavaUtilList.get(i);
        bliy.a().c(localblab.f);
        bliy.a().b(i + 1);
        bliu.a().f(localblab.a);
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
    if (this.jdField_a_of_type_Blfz != null) {
      this.jdField_a_of_type_Blfz.b();
    }
  }
  
  public void setTabId(String paramString)
  {
    this.jdField_a_of_type_Blfz.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowPageView
 * JD-Core Version:    0.7.0.1
 */