package dov.com.qq.im.aeeditor.module.edit;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import blfg;
import blgb;
import blip;
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.tavcut.view.TAVCutImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AEEditorImagePagerAdapter
  extends PagerAdapter
{
  private static final String jdField_a_of_type_JavaLangString = AEEditorImagePagerAdapter.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private blip jdField_a_of_type_Blip;
  private TAVCutImageSession jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession;
  private HashMap<String, blgb> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private HashMap<Integer, Boolean> b = new HashMap();
  
  public AEEditorImagePagerAdapter(TAVCutImageSession paramTAVCutImageSession, List<String> paramList, List<blgb> paramList1, blip paramblip)
  {
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession = paramTAVCutImageSession;
    this.jdField_a_of_type_Blip = paramblip;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
    paramTAVCutImageSession = paramList1.iterator();
    while (paramTAVCutImageSession.hasNext())
    {
      paramList = (blgb)paramTAVCutImageSession.next();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramList.jdField_a_of_type_JavaLangString, paramList);
    }
  }
  
  private void a(ViewGroup paramViewGroup, int paramInt, TAVCutImageView paramTAVCutImageView)
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    localObject = (blgb)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
    int i = ((blgb)localObject).jdField_a_of_type_Int;
    int j = ((blgb)localObject).b;
    double d1 = i * ((blgb)localObject).jdField_a_of_type_ComTencentTavcutBeanCropConfig.getWidth();
    float f = j;
    double d2 = ((blgb)localObject).jdField_a_of_type_ComTencentTavcutBeanCropConfig.getHeight() * f;
    localObject = paramTAVCutImageView.getLayoutParams();
    this.jdField_a_of_type_Int = paramViewGroup.getHeight();
    i = paramViewGroup.getWidth();
    j = paramViewGroup.getHeight();
    double d3;
    if (d1 / d2 > i * 1.0D / j)
    {
      ((ViewGroup.LayoutParams)localObject).width = i;
      d3 = ((ViewGroup.LayoutParams)localObject).width;
      ((ViewGroup.LayoutParams)localObject).height = ((int)(d2 / d1 * d3));
    }
    for (;;)
    {
      paramTAVCutImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setTAVCutImageView(paramInt, paramTAVCutImageView);
      if (this.jdField_a_of_type_Blip != null) {
        this.jdField_a_of_type_Blip.a(paramInt);
      }
      blfg.b(jdField_a_of_type_JavaLangString, "render position = " + paramInt);
      return;
      ((ViewGroup.LayoutParams)localObject).height = j;
      d3 = ((ViewGroup.LayoutParams)localObject).height;
      ((ViewGroup.LayoutParams)localObject).width = ((int)(d1 / d2 * d3));
    }
  }
  
  public void a()
  {
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if (((Boolean)this.b.get(localInteger)).booleanValue() == true) {
        this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.releaseTAVCutImageView(localInteger.intValue());
      }
    }
  }
  
  public void destroyItem(@NonNull ViewGroup paramViewGroup, int paramInt, @NonNull Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
    this.b.put(Integer.valueOf(paramInt), Boolean.valueOf(false));
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.releaseTAVCutImageView(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  @NonNull
  public Object instantiateItem(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    View localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558532, null);
    TAVCutImageView localTAVCutImageView = (TAVCutImageView)localView.findViewById(2131377414);
    this.b.put(Integer.valueOf(paramInt), Boolean.valueOf(true));
    AEEditorImagePagerAdapter.1 local1 = new AEEditorImagePagerAdapter.1(this, paramViewGroup, paramInt, localTAVCutImageView);
    if (this.jdField_a_of_type_Int == 0) {
      localTAVCutImageView.post(local1);
    }
    for (;;)
    {
      paramViewGroup.addView(localView, new ViewGroup.LayoutParams(-1, -1));
      return localView;
      local1.run();
    }
  }
  
  public boolean isViewFromObject(@NonNull View paramView, @NonNull Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImagePagerAdapter
 * JD-Core Version:    0.7.0.1
 */