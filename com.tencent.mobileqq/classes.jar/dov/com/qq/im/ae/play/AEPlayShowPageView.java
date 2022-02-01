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
import bgtn;
import bndy;
import bnpf;
import bnvb;
import bnvh;
import bnvk;
import bnvp;
import bnvq;
import bnyh;
import bnyl;
import bnzb;
import java.util.List;

public class AEPlayShowPageView
  extends FrameLayout
{
  private static final bnvk jdField_a_of_type_Bnvk = a(1);
  private static final bnvk b = a(2);
  private int jdField_a_of_type_Int = 2;
  private GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private bnvb jdField_a_of_type_Bnvb;
  private bnvh jdField_a_of_type_Bnvh;
  private List<bnpf> jdField_a_of_type_JavaUtilList;
  
  public AEPlayShowPageView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, @NonNull bnvb parambnvb, int paramInt2, @NonNull List<bnpf> paramList)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    a(parambnvb, paramInt2, paramList);
    a(paramContext);
  }
  
  public AEPlayShowPageView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @NonNull bnvb parambnvb, int paramInt, @NonNull List<bnpf> paramList)
  {
    this(paramContext, paramAttributeSet, 0, parambnvb, paramInt, paramList);
  }
  
  public AEPlayShowPageView(@NonNull Context paramContext, @NonNull bnvb parambnvb, int paramInt, @NonNull List<bnpf> paramList)
  {
    this(paramContext, null, parambnvb, paramInt, paramList);
  }
  
  private static bnvk a(int paramInt)
  {
    int j = bgtn.a(10.0F);
    int k = bgtn.a(4.0F);
    int m = (int)(k * 0.96F);
    if (paramInt == 1) {}
    for (int i = bgtn.a() - j * 2 - k * 2;; i = (bgtn.a() - j * 2 - k * 4) / 2)
    {
      int n = (int)(i * 0.96F * 59.0F / 34.0F);
      bnvk localbnvk = new bnvk();
      localbnvk.jdField_a_of_type_Int = (i + k * 2);
      localbnvk.b = (m * 2 + n);
      localbnvk.c = k;
      localbnvk.d = m;
      if (paramInt == 1) {
        localbnvk.d = j;
      }
      return localbnvk;
    }
  }
  
  private void a(@NonNull Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131558536, this, true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131362262));
    bnzb.a("AEPlayShowPart", "rv toString " + this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.toString());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new bnvp(this));
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(paramContext, 1, 1, false);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
      if (this.jdField_a_of_type_Int != 1) {
        break label198;
      }
    }
    label198:
    for (bnvk localbnvk = new bnvk(jdField_a_of_type_Bnvk);; localbnvk = new bnvk(b))
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new bnvq(this, localbnvk));
      this.jdField_a_of_type_Bnvh = new bnvh(paramContext, this.jdField_a_of_type_Bnvb, localbnvk, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bnvh);
      a(this.jdField_a_of_type_JavaUtilList);
      return;
      this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(paramContext, 2, 1, false);
      break;
    }
  }
  
  private void a(@NonNull bnvb parambnvb, int paramInt, @NonNull List<bnpf> paramList)
  {
    this.jdField_a_of_type_Bnvb = parambnvb;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bnvb == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_Bnvb.a(65537, new Object[0]);
      } while (!(localObject instanceof bndy));
      localObject = (bndy)localObject;
    } while ((((bndy)localObject).a() == null) || (((bndy)localObject).a().getIntent() == null));
    ((bndy)localObject).a().getIntent().putExtra("KEY_CURRENT_SELECT_ID", "");
    ((bndy)localObject).a().getIntent().putExtra("KEY_CURRENT_TYPE", "");
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bnvh.a();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager != null) {
        this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.scrollToPositionWithOffset(paramInt, 0);
      }
      bnzb.a("AEPlayShowPart", "out........" + this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.toString());
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.post(new AEPlayShowPageView.3(this, paramInt));
    }
  }
  
  public void a(@NonNull List<bnpf> paramList)
  {
    if (this.jdField_a_of_type_Bnvh != null) {
      this.jdField_a_of_type_Bnvh.a(paramList);
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
        bnpf localbnpf = (bnpf)this.jdField_a_of_type_JavaUtilList.get(i);
        bnyl.a().c(localbnpf.g);
        bnyl.a().b(i + 1);
        bnyh.a().g(localbnpf.a);
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
    if (this.jdField_a_of_type_Bnvh != null) {
      this.jdField_a_of_type_Bnvh.b();
    }
  }
  
  public void setTabId(String paramString)
  {
    this.jdField_a_of_type_Bnvh.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowPageView
 * JD-Core Version:    0.7.0.1
 */