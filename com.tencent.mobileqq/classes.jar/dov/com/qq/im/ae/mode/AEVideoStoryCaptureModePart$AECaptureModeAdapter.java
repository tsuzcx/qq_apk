package dov.com.qq.im.ae.mode;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

class AEVideoStoryCaptureModePart$AECaptureModeAdapter
  extends PagerAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<AEVideoStoryCaptureModePart.AECaptureModeAdapter.ViewHolder> jdField_a_of_type_AndroidUtilSparseArray;
  
  AEVideoStoryCaptureModePart$AECaptureModeAdapter(AEVideoStoryCaptureModePart paramAEVideoStoryCaptureModePart, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    if (AEVideoStoryCaptureModePart.a(this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModePart) == null) {
      return 0;
    }
    return AEVideoStoryCaptureModePart.a(this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModePart).length;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  @SuppressLint({"ResourceType"})
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject2 = (AEVideoStoryCaptureModePart.AECaptureModeAdapter.ViewHolder)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558485, null);
      localObject1 = new AEVideoStoryCaptureModePart.AECaptureModeAdapter.ViewHolder(this);
      ((AEVideoStoryCaptureModePart.AECaptureModeAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView = ((View)localObject2);
      ((AEVideoStoryCaptureModePart.AECaptureModeAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131371803));
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
    }
    localObject2 = AEVideoStoryCaptureModePart.a(this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModePart)[paramInt];
    TextView localTextView = ((AEVideoStoryCaptureModePart.AECaptureModeAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView;
    localTextView.setText(((AECaptureMode)localObject2).textId);
    if (AEVideoStoryCaptureModePart.a(this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModePart))
    {
      localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165357));
      if (AEVideoStoryCaptureModePart.a(this.jdField_a_of_type_DovComQqImAeModeAEVideoStoryCaptureModePart) != localObject2) {
        break label220;
      }
      localTextView.setAlpha(1.0F);
    }
    for (;;)
    {
      localTextView.setOnClickListener(new AEVideoStoryCaptureModePart.AECaptureModeAdapter.1(this, (AECaptureMode)localObject2, paramInt));
      paramViewGroup.addView(((AEVideoStoryCaptureModePart.AECaptureModeAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView);
      return ((AEVideoStoryCaptureModePart.AECaptureModeAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidViewView;
      localTextView.setShadowLayer(4.0F, 0.0F, 2.0F, localTextView.getResources().getColor(2131165369));
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167374));
      break;
      label220:
      localTextView.setAlpha(0.6F);
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.mode.AEVideoStoryCaptureModePart.AECaptureModeAdapter
 * JD-Core Version:    0.7.0.1
 */