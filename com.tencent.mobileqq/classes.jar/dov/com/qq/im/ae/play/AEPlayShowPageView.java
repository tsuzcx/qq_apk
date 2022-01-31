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
import bbll;
import bijd;
import bire;
import biws;
import biwy;
import bixb;
import bixg;
import bixh;
import bizt;
import bizx;
import bjah;
import java.util.List;

public class AEPlayShowPageView
  extends FrameLayout
{
  private static final bixb jdField_a_of_type_Bixb = a(1);
  private static final bixb b = a(2);
  private int jdField_a_of_type_Int = 2;
  private GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private biws jdField_a_of_type_Biws;
  private biwy jdField_a_of_type_Biwy;
  private List<bire> jdField_a_of_type_JavaUtilList;
  
  public AEPlayShowPageView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, @NonNull biws parambiws, int paramInt2, @NonNull List<bire> paramList)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    a(parambiws, paramInt2, paramList);
    a(paramContext);
  }
  
  public AEPlayShowPageView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @NonNull biws parambiws, int paramInt, @NonNull List<bire> paramList)
  {
    this(paramContext, paramAttributeSet, 0, parambiws, paramInt, paramList);
  }
  
  public AEPlayShowPageView(@NonNull Context paramContext, @NonNull biws parambiws, int paramInt, @NonNull List<bire> paramList)
  {
    this(paramContext, null, parambiws, paramInt, paramList);
  }
  
  private static bixb a(int paramInt)
  {
    int j = bbll.a(10.0F);
    int k = bbll.a(4.0F);
    int m = (int)(k * 0.96F);
    if (paramInt == 1) {}
    for (int i = bbll.a() - j * 2 - k * 2;; i = (bbll.a() - j * 2 - k * 4) / 2)
    {
      int n = (int)(i * 0.96F * 59.0F / 34.0F);
      bixb localbixb = new bixb();
      localbixb.jdField_a_of_type_Int = (i + k * 2);
      localbixb.b = (m * 2 + n);
      localbixb.c = k;
      localbixb.d = m;
      if (paramInt == 1) {
        localbixb.d = j;
      }
      return localbixb;
    }
  }
  
  private void a(@NonNull Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131558517, this, true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131362175));
    bjah.a("AEPlayShowPart", "rv toString " + this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.toString());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new bixg(this));
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(paramContext, 1, 1, false);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
      if (this.jdField_a_of_type_Int != 1) {
        break label198;
      }
    }
    label198:
    for (bixb localbixb = new bixb(jdField_a_of_type_Bixb);; localbixb = new bixb(b))
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new bixh(this, localbixb));
      this.jdField_a_of_type_Biwy = new biwy(paramContext, this.jdField_a_of_type_Biws, localbixb, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Biwy);
      a(this.jdField_a_of_type_JavaUtilList);
      return;
      this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(paramContext, 2, 1, false);
      break;
    }
  }
  
  private void a(@NonNull biws parambiws, int paramInt, @NonNull List<bire> paramList)
  {
    this.jdField_a_of_type_Biws = parambiws;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Biws == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_Biws.a(65537, new Object[0]);
      } while (!(localObject instanceof bijd));
      localObject = (bijd)localObject;
    } while ((((bijd)localObject).a() == null) || (((bijd)localObject).a().getIntent() == null));
    ((bijd)localObject).a().getIntent().putExtra("KEY_CURRENT_SELECT_ID", "");
    ((bijd)localObject).a().getIntent().putExtra("KEY_CURRENT_TYPE", "");
  }
  
  public void a()
  {
    this.jdField_a_of_type_Biwy.a();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager != null) {
        this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.scrollToPositionWithOffset(paramInt, 0);
      }
      bjah.a("AEPlayShowPart", "out........" + this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.toString());
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.post(new AEPlayShowPageView.3(this, paramInt));
    }
  }
  
  public void a(@NonNull List<bire> paramList)
  {
    if (this.jdField_a_of_type_Biwy != null) {
      this.jdField_a_of_type_Biwy.a(paramList);
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
        bire localbire = (bire)this.jdField_a_of_type_JavaUtilList.get(i);
        bizx.a().c(localbire.f);
        bizx.a().b(i + 1);
        bizt.a().e(localbire.a);
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
    if (this.jdField_a_of_type_Biwy != null) {
      this.jdField_a_of_type_Biwy.b();
    }
  }
  
  public void setTabId(String paramString)
  {
    this.jdField_a_of_type_Biwy.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowPageView
 * JD-Core Version:    0.7.0.1
 */