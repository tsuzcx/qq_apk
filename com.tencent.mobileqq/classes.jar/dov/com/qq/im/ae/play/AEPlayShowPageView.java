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
import bhtq;
import bofh;
import boqu;
import bown;
import bowt;
import bowu;
import bowz;
import boxa;
import bozr;
import bozv;
import bpam;
import java.util.List;

public class AEPlayShowPageView
  extends FrameLayout
{
  private static final bowu jdField_a_of_type_Bowu = a(1);
  private static final bowu b = a(2);
  private int jdField_a_of_type_Int = 2;
  private GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private bown jdField_a_of_type_Bown;
  private bowt jdField_a_of_type_Bowt;
  private List<boqu> jdField_a_of_type_JavaUtilList;
  
  public AEPlayShowPageView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, @NonNull bown parambown, int paramInt2, @NonNull List<boqu> paramList)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    a(parambown, paramInt2, paramList);
    a(paramContext);
  }
  
  public AEPlayShowPageView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @NonNull bown parambown, int paramInt, @NonNull List<boqu> paramList)
  {
    this(paramContext, paramAttributeSet, 0, parambown, paramInt, paramList);
  }
  
  public AEPlayShowPageView(@NonNull Context paramContext, @NonNull bown parambown, int paramInt, @NonNull List<boqu> paramList)
  {
    this(paramContext, null, parambown, paramInt, paramList);
  }
  
  private static bowu a(int paramInt)
  {
    int j = bhtq.a(10.0F);
    int k = bhtq.a(4.0F);
    int m = (int)(k * 0.96F);
    if (paramInt == 1) {}
    for (int i = bhtq.a() - j * 2 - k * 2;; i = (bhtq.a() - j * 2 - k * 4) / 2)
    {
      int n = (int)(i * 0.96F * 59.0F / 34.0F);
      bowu localbowu = new bowu();
      localbowu.jdField_a_of_type_Int = (i + k * 2);
      localbowu.b = (m * 2 + n);
      localbowu.c = k;
      localbowu.d = m;
      if (paramInt == 1) {
        localbowu.d = j;
      }
      return localbowu;
    }
  }
  
  private void a(@NonNull Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131558538, this, true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131362274));
    bpam.a("AEPlayShowPart", "rv toString " + this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.toString());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new bowz(this));
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(paramContext, 1, 1, false);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
      if (this.jdField_a_of_type_Int != 1) {
        break label198;
      }
    }
    label198:
    for (bowu localbowu = new bowu(jdField_a_of_type_Bowu);; localbowu = new bowu(b))
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new boxa(this, localbowu));
      this.jdField_a_of_type_Bowt = new bowt(paramContext, this.jdField_a_of_type_Bown, localbowu, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bowt);
      a(this.jdField_a_of_type_JavaUtilList);
      return;
      this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(paramContext, 2, 1, false);
      break;
    }
  }
  
  private void a(@NonNull bown parambown, int paramInt, @NonNull List<boqu> paramList)
  {
    this.jdField_a_of_type_Bown = parambown;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bown == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_Bown.a(65537, new Object[0]);
      } while (!(localObject instanceof bofh));
      localObject = (bofh)localObject;
    } while ((((bofh)localObject).a() == null) || (((bofh)localObject).a().getIntent() == null));
    ((bofh)localObject).a().getIntent().putExtra("KEY_CURRENT_SELECT_ID", "");
    ((bofh)localObject).a().getIntent().putExtra("KEY_CURRENT_TYPE", "");
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bowt.a();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager != null) {
        this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.scrollToPositionWithOffset(paramInt, 0);
      }
      bpam.a("AEPlayShowPart", "out........" + this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.toString());
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.post(new AEPlayShowPageView.3(this, paramInt));
    }
  }
  
  public void a(@NonNull List<boqu> paramList)
  {
    if (this.jdField_a_of_type_Bowt != null) {
      this.jdField_a_of_type_Bowt.a(paramList);
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
        boqu localboqu = (boqu)this.jdField_a_of_type_JavaUtilList.get(i);
        bozv.a().d(localboqu.g);
        bozv.a().c(i + 1);
        bozr.a().g(localboqu.a);
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
    if (this.jdField_a_of_type_Bowt != null) {
      this.jdField_a_of_type_Bowt.b();
    }
  }
  
  public void setTabId(String paramString)
  {
    this.jdField_a_of_type_Bowt.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowPageView
 * JD-Core Version:    0.7.0.1
 */