package dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import bnae;
import bnaf;
import bnag;
import bnah;
import bnai;
import bnaj;
import bnan;
import bnao;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

public class HorizontalSelectColorLayout
  extends RelativeLayout
{
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  bnah jdField_a_of_type_Bnah;
  public bnai a;
  bnaj jdField_a_of_type_Bnaj;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  ArrayList<bnao> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
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
    LayoutInflater.from(getContext()).inflate(2131561460, this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)super.findViewById(2131364433));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setStayDisplayOffsetZero(true);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(new bnae(this));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemSelectedListener(new bnaf(this));
    this.jdField_a_of_type_Bnaj = new bnaj(this, getContext());
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Bnaj);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131379225));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bnag(this));
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Long > System.currentTimeMillis()) {}
    do
    {
      return;
      this.jdField_a_of_type_Bnaj.a(paramInt);
      this.jdField_a_of_type_Int = paramInt;
    } while (this.jdField_a_of_type_Bnah == null);
    this.jdField_a_of_type_Bnah.a(a());
  }
  
  public bnao a()
  {
    return (bnao)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
  }
  
  public void setAnimationEndTime(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void setEditDialogMode(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setOnStrokeSelectedListener(bnah parambnah)
  {
    this.jdField_a_of_type_Bnah = parambnah;
  }
  
  public void setOnUndoViewClickListener(bnai parambnai)
  {
    this.jdField_a_of_type_Bnai = parambnai;
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
        bnao localbnao = (bnao)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localbnao.jdField_a_of_type_Int != paramInt1) || (localbnao.b != paramInt2)) {
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
        bnao localbnao = (bnao)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localbnao.jdField_a_of_type_Int == 0) && (localbnao.b == paramInt)) {
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
  
  public void setStrokeStrategy(bnan parambnan, boolean paramBoolean, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    int i;
    label35:
    View localView;
    if (paramBoolean)
    {
      i = 0;
      ((ImageView)localObject).setVisibility(i);
      localObject = super.findViewById(2131379226);
      if (!paramBoolean) {
        break label120;
      }
      i = 0;
      ((View)localObject).setVisibility(i);
      localObject = super.findViewById(2131378109);
      localView = super.findViewById(2131363408);
      if (paramInt != 1) {
        break label127;
      }
      ((View)localObject).setVisibility(0);
    }
    for (;;)
    {
      if (parambnan == null) {
        break label161;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      parambnan.a(this.jdField_a_of_type_JavaUtilArrayList, getContext());
      if (this.jdField_a_of_type_Bnaj != null) {
        this.jdField_a_of_type_Bnaj.a(this.jdField_a_of_type_JavaUtilArrayList);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout
 * JD-Core Version:    0.7.0.1
 */