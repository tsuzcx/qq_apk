package dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import bphn;
import bpho;
import bphp;
import bphq;
import bphr;
import bphs;
import bphw;
import bphx;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

public class HorizontalSelectColorLayout
  extends RelativeLayout
{
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  bphq jdField_a_of_type_Bphq;
  public bphr a;
  bphs jdField_a_of_type_Bphs;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  ArrayList<bphx> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean;
  public boolean b = false;
  
  public HorizontalSelectColorLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public HorizontalSelectColorLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    LayoutInflater.from(getContext()).inflate(2131561700, this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)super.findViewById(2131364805));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setStayDisplayOffsetZero(true);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(new bphn(this));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemSelectedListener(new bpho(this));
    this.jdField_a_of_type_Bphs = new bphs(this, getContext());
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Bphs);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131380455));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bphp(this));
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Long > System.currentTimeMillis()) {}
    do
    {
      return;
      this.jdField_a_of_type_Bphs.a(paramInt);
      this.jdField_a_of_type_Int = paramInt;
    } while (this.jdField_a_of_type_Bphq == null);
    this.jdField_a_of_type_Bphq.a(a());
  }
  
  public bphx a()
  {
    return (bphx)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
  }
  
  public void setAnimationEndTime(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void setEditDialogMode(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setOnStrokeSelectedListener(bphq parambphq)
  {
    this.jdField_a_of_type_Bphq = parambphq;
  }
  
  public void setOnUndoViewClickListener(bphr parambphr)
  {
    this.jdField_a_of_type_Bphr = parambphr;
  }
  
  public void setSelectedStroke(int paramInt1, int paramInt2)
  {
    int i;
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        bphx localbphx = (bphx)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localbphx.jdField_a_of_type_Int != paramInt1) || (localbphx.b != paramInt2)) {
          break label73;
        }
        a(i);
        if (i > 5) {
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView.smoothScrollToPosition(i);
        }
      }
      return;
      label73:
      i += 1;
    }
  }
  
  public void setSelectedStrokeWithColor(int paramInt)
  {
    int i;
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        bphx localbphx = (bphx)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localbphx.jdField_a_of_type_Int == 0) && (localbphx.b == paramInt)) {
          a(i);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public void setStrokeStrategy(bphw parambphw, boolean paramBoolean, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    int i;
    label35:
    View localView;
    if (paramBoolean)
    {
      i = 0;
      ((ImageView)localObject).setVisibility(i);
      localObject = super.findViewById(2131380456);
      if (!paramBoolean) {
        break label120;
      }
      i = 0;
      ((View)localObject).setVisibility(i);
      localObject = super.findViewById(2131379237);
      localView = super.findViewById(2131363727);
      if (paramInt != 1) {
        break label127;
      }
      ((View)localObject).setVisibility(0);
    }
    for (;;)
    {
      if (parambphw == null) {
        break label161;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      parambphw.a(this.jdField_a_of_type_JavaUtilArrayList, getContext());
      if (this.jdField_a_of_type_Bphs != null) {
        this.jdField_a_of_type_Bphs.a(this.jdField_a_of_type_JavaUtilArrayList);
      }
      return;
      i = 8;
      break;
      label120:
      i = 8;
      break label35;
      label127:
      if (paramInt == 2)
      {
        localView.setVisibility(0);
      }
      else if (paramInt == 3)
      {
        ((View)localObject).setVisibility(0);
        localView.setVisibility(0);
      }
    }
    label161:
    setVisibility(8);
  }
  
  public void setUndoViewEnable(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout
 * JD-Core Version:    0.7.0.1
 */