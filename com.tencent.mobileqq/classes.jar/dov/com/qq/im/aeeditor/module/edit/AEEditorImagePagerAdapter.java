package dov.com.qq.im.aeeditor.module.edit;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.tavcut.view.TAVCutImageView;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.data.AEEditorImageInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AEEditorImagePagerAdapter
  extends PagerAdapter
{
  private static final String jdField_a_of_type_JavaLangString = AEEditorImagePagerAdapter.class.getSimpleName();
  private int jdField_a_of_type_Int = 0;
  private SparseArray<String> jdField_a_of_type_AndroidUtilSparseArray;
  private TAVCutImageSession jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession;
  private AEEditorImagePagerAdapter.ImagePagerAdapterCallback jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter$ImagePagerAdapterCallback;
  private HashMap<String, AEEditorImageInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private HashMap<Integer, Boolean> b = new HashMap();
  
  public AEEditorImagePagerAdapter(TAVCutImageSession paramTAVCutImageSession, List<String> paramList, List<AEEditorImageInfo> paramList1, SparseArray<String> paramSparseArray, AEEditorImagePagerAdapter.ImagePagerAdapterCallback paramImagePagerAdapterCallback)
  {
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession = paramTAVCutImageSession;
    this.jdField_a_of_type_AndroidUtilSparseArray = paramSparseArray;
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter$ImagePagerAdapterCallback = paramImagePagerAdapterCallback;
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
    paramTAVCutImageSession = paramList1.iterator();
    while (paramTAVCutImageSession.hasNext())
    {
      paramList = (AEEditorImageInfo)paramTAVCutImageSession.next();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramList.jdField_a_of_type_JavaLangString, paramList);
    }
  }
  
  private void a(ViewGroup paramViewGroup, int paramInt, TAVCutImageView paramTAVCutImageView)
  {
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setTAVCutImageView(paramInt, paramTAVCutImageView);
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter$ImagePagerAdapterCallback != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter$ImagePagerAdapterCallback.a(paramInt);
    }
    AEQLog.b(jdField_a_of_type_JavaLangString, "render position = " + paramInt);
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
    View localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558581, null);
    TAVCutImageView localTAVCutImageView = (TAVCutImageView)localView.findViewById(2131378946);
    localTAVCutImageView.setTag(Integer.valueOf(paramInt));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImagePagerAdapter
 * JD-Core Version:    0.7.0.1
 */