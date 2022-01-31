package dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import aoez;
import aofa;
import aofb;
import aofc;
import com.tencent.widget.HorizontalListView;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.strategy.StrokeStrategy;
import dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke.HorizontalStroke;
import java.util.ArrayList;

public class HorizontalSelectColorLayout
  extends RelativeLayout
{
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  aofc jdField_a_of_type_Aofc;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  HorizontalSelectColorLayout.OnStrokeSelectedListener jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$OnStrokeSelectedListener;
  public HorizontalSelectColorLayout.OnUndoViewClickListener a;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean;
  
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
    LayoutInflater.from(getContext()).inflate(2130970751, this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)super.findViewById(2131371817));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setStayDisplayOffsetZero(true);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(new aoez(this));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemSelectedListener(new aofa(this));
    this.jdField_a_of_type_Aofc = new aofc(this, getContext());
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Aofc);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131371818));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aofb(this));
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Long > System.currentTimeMillis()) {}
    do
    {
      return;
      this.jdField_a_of_type_Aofc.a(paramInt);
      this.jdField_a_of_type_Int = paramInt;
    } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$OnStrokeSelectedListener == null);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$OnStrokeSelectedListener.a(a());
  }
  
  public HorizontalStroke a()
  {
    return (HorizontalStroke)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
  }
  
  public void setAnimationEndTime(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void setOnStrokeSelectedListener(HorizontalSelectColorLayout.OnStrokeSelectedListener paramOnStrokeSelectedListener)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$OnStrokeSelectedListener = paramOnStrokeSelectedListener;
  }
  
  public void setOnUndoViewClickListener(HorizontalSelectColorLayout.OnUndoViewClickListener paramOnUndoViewClickListener)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$OnUndoViewClickListener = paramOnUndoViewClickListener;
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
        HorizontalStroke localHorizontalStroke = (HorizontalStroke)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localHorizontalStroke.jdField_a_of_type_Int == 0) && (localHorizontalStroke.b == paramInt)) {
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
  
  public void setStrokeStrategy(StrokeStrategy paramStrokeStrategy, boolean paramBoolean, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    int i;
    label35:
    View localView;
    if (paramBoolean)
    {
      i = 0;
      ((ImageView)localObject).setVisibility(i);
      localObject = super.findViewById(2131371819);
      if (!paramBoolean) {
        break label120;
      }
      i = 0;
      ((View)localObject).setVisibility(i);
      localObject = super.findViewById(2131369750);
      localView = super.findViewById(2131363259);
      if (paramInt != 1) {
        break label127;
      }
      ((View)localObject).setVisibility(0);
    }
    for (;;)
    {
      if (paramStrokeStrategy == null) {
        break label161;
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      paramStrokeStrategy.b(this.jdField_a_of_type_JavaUtilArrayList, getContext());
      if (this.jdField_a_of_type_Aofc != null) {
        this.jdField_a_of_type_Aofc.a(this.jdField_a_of_type_JavaUtilArrayList);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout
 * JD-Core Version:    0.7.0.1
 */