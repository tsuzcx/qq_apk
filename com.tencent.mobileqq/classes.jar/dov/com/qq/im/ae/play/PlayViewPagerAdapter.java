package dov.com.qq.im.ae.play;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import bnka;
import bnke;
import bnqc;
import bnqq;
import bnrh;
import java.util.LinkedList;
import java.util.List;

public class PlayViewPagerAdapter
  extends PagerAdapter
{
  public static final String DEFAULT_TAB_ID = "-1";
  private AEPlayShowPageView currentPageView;
  private int lastPos = -1;
  private List<bnka> mCategoryList;
  private Context mContext;
  private bnqc mPartManager;
  
  public PlayViewPagerAdapter(@NonNull Context paramContext, @NonNull bnqc parambnqc, @NonNull List<bnka> paramList)
  {
    this.mContext = paramContext;
    this.mPartManager = parambnqc;
    this.mCategoryList = paramList;
  }
  
  private int getLayoutType(int paramInt)
  {
    bnka localbnka = (bnka)this.mCategoryList.get(paramInt);
    if (localbnka == null) {
      return 2;
    }
    return localbnka.b;
  }
  
  private List<bnke> getMaterialList(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.mCategoryList != null)
    {
      localObject1 = localObject2;
      if (this.mCategoryList.size() > paramInt) {
        localObject1 = (bnka)this.mCategoryList.get(paramInt);
      }
    }
    if ((localObject1 == null) || (((bnka)localObject1).jdField_a_of_type_JavaUtilList == null)) {
      return new LinkedList();
    }
    return ((bnka)localObject1).jdField_a_of_type_JavaUtilList;
  }
  
  private String getMaterialTabId(int paramInt)
  {
    if ((this.mCategoryList != null) && (this.mCategoryList.size() > paramInt)) {
      return ((bnka)this.mCategoryList.get(paramInt)).jdField_a_of_type_JavaLangString;
    }
    return "-1";
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if ((paramObject instanceof AEPlayShowPageView)) {
      ((AEPlayShowPageView)paramObject).onDestroy();
    }
    bnrh.a("AEPlayShowPart", "page destroy.......");
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    if (this.mCategoryList == null) {
      return 0;
    }
    return this.mCategoryList.size();
  }
  
  public AEPlayShowPageView getCurrentPageView()
  {
    return this.currentPageView;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public String getLastMaterialTabId()
  {
    if (this.lastPos <= 0) {
      return "-1";
    }
    return getMaterialTabId(this.lastPos);
  }
  
  public List<bnka> getmCategoryList()
  {
    return this.mCategoryList;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AEPlayShowPageView localAEPlayShowPageView = new AEPlayShowPageView(this.mContext, this.mPartManager, getLayoutType(paramInt), getMaterialList(paramInt));
    paramViewGroup.addView(localAEPlayShowPageView);
    return localAEPlayShowPageView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void setCategoryList(List<bnka> paramList)
  {
    this.mCategoryList = paramList;
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    super.setPrimaryItem(paramViewGroup, paramInt, paramObject);
    if ((paramObject instanceof AEPlayShowPageView)) {
      this.currentPageView = ((AEPlayShowPageView)paramObject);
    }
    if (this.lastPos != paramInt)
    {
      this.lastPos = paramInt;
      if ((this.mCategoryList != null) && (this.mCategoryList.size() > paramInt))
      {
        paramViewGroup = (bnka)this.mCategoryList.get(paramInt);
        if (paramViewGroup != null) {
          bnqq.a().g(paramViewGroup.jdField_a_of_type_JavaLangString + "");
        }
      }
      if ((paramObject instanceof AEPlayShowPageView))
      {
        this.currentPageView.post(new PlayViewPagerAdapter.1(this, paramInt));
        this.currentPageView.initDownloadObservers();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.PlayViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */