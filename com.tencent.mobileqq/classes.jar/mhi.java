import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.av.ui.QAVPtvTemplateAdapter.6;
import com.tencent.av.ui.QAVPtvTemplateAdapter.7;
import com.tencent.av.ui.QavListItemBase;
import com.tencent.av.ui.QavPtvTemplateItemView;
import com.tencent.av.ui.VoiceChangeItemView2;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class mhi
  extends BaseAdapter
{
  public static int a;
  public static int b;
  public static int c;
  float jdField_a_of_type_Float = 6.25F;
  long jdField_a_of_type_Long = 0L;
  public Context a;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private View jdField_a_of_type_AndroidViewView;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public HorizontalListView a;
  public ArrayList<mii> a;
  mho jdField_a_of_type_Mho;
  mhp jdField_a_of_type_Mhp;
  private mig jdField_a_of_type_Mig = new mhm(this);
  private mih jdField_a_of_type_Mih = new mhn(this);
  boolean jdField_a_of_type_Boolean = false;
  boolean b;
  public boolean c;
  public volatile int d = -1;
  protected int e = -1;
  
  public mhi(AppInterface paramAppInterface, Context paramContext, ArrayList<mii> paramArrayList, HorizontalListView paramHorizontalListView)
  {
    this(paramAppInterface, paramContext, paramArrayList, paramHorizontalListView, 6.25F);
  }
  
  public mhi(AppInterface paramAppInterface, Context paramContext, ArrayList<mii> paramArrayList, HorizontalListView paramHorizontalListView, float paramFloat)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = paramHorizontalListView;
    this.jdField_a_of_type_Float = paramFloat;
    a(paramArrayList);
    jdField_a_of_type_Int = a(this.jdField_a_of_type_AndroidContentResResources, a());
    jdField_b_of_type_Int = a(this.jdField_a_of_type_AndroidContentResResources, a(), 0.1666667F);
    jdField_c_of_type_Int = jdField_a_of_type_Int + agej.a(30.0F, this.jdField_a_of_type_AndroidContentResResources);
    if (this.jdField_a_of_type_Float < 6.0F) {
      jdField_c_of_type_Int = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297548);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("QAVPtvTemplateAdapter", 4, "init, w[" + jdField_a_of_type_Int + "], h[" + jdField_c_of_type_Int + "], half[" + jdField_b_of_type_Int + "]");
    }
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.addOnLayoutChangeListener(new mhj(this));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnScrollStateChangedListener(new mhk(this));
    paramAppInterface = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLayoutParams();
    paramAppInterface.width = -1;
    paramAppInterface.height = jdField_c_of_type_Int;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setLayoutParams(paramAppInterface);
  }
  
  public static int a(Resources paramResources, float paramFloat)
  {
    return (int)(paramResources.getDisplayMetrics().widthPixels / paramFloat + 0.5F);
  }
  
  public static int a(Resources paramResources, float paramFloat1, float paramFloat2)
  {
    return (int)(paramResources.getDisplayMetrics().widthPixels / paramFloat1 * paramFloat2 + 0.5F);
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public mii a()
  {
    if ((this.e < 0) || (this.e >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return null;
    }
    return (mii)this.jdField_a_of_type_JavaUtilArrayList.get(this.e);
  }
  
  public mii a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return null;
    }
    return (mii)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition() >= paramInt) {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.smoothScrollToPositionFromLeftOrRight(paramInt, 0, 200);
    }
    View localView;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition() > paramInt);
      localView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChild(paramInt);
    } while ((localView != null) && (localView.getRight() <= this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getRight()));
    if (paramInt == getCount() - 1) {}
    for (int i = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().widthPixels - jdField_a_of_type_Int;; i = jdField_a_of_type_Int * 5)
    {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.smoothScrollToPositionFromLeftOrRight(paramInt, -i, 200);
      return;
    }
  }
  
  void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      View localView1 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChild(paramInt1);
      View localView2 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChild(paramInt2);
      if ((paramInt2 != paramInt1) && (localView1 != null) && ((localView1 instanceof QavListItemBase))) {
        ((QavListItemBase)localView1).setHighlight(false);
      }
      if ((localView2 != null) && ((localView2 instanceof QavListItemBase))) {
        ((QavListItemBase)localView2).setHighlight(true);
      }
    }
  }
  
  protected void a(long paramLong, int paramInt)
  {
    if ((paramInt < 0) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= paramInt)) {}
    mii localmii;
    do
    {
      return;
      localmii = (mii)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if ((TextUtils.isEmpty(localmii.jdField_a_of_type_JavaLangString)) || (localmii.jdField_a_of_type_JavaLangString.equals("0")))
      {
        a(paramLong, localmii);
        return;
      }
      if (localmii.jdField_a_of_type_Boolean)
      {
        a(paramLong, localmii);
        return;
      }
    } while ((localmii.jdField_b_of_type_Boolean) || (TextUtils.isEmpty(localmii.jdField_a_of_type_JavaLangString)));
    if (this.jdField_a_of_type_Mhp != null)
    {
      this.jdField_a_of_type_Mhp.startDownloadTemplate(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramLong, localmii, this.jdField_a_of_type_Mih);
      localmii.jdField_b_of_type_Boolean = true;
      return;
    }
    throw new IllegalArgumentException("mIItemDownloadMgr is null, pealse call setItemDownloadMgr");
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.post(new QAVPtvTemplateAdapter.6(this, paramString, paramBoolean, paramLong));
  }
  
  public void a(long paramLong, mii parammii)
  {
    if (this.jdField_a_of_type_Mho == null) {}
    while ((!TextUtils.isEmpty(parammii.jdField_a_of_type_JavaLangString)) && (!parammii.jdField_a_of_type_JavaLangString.equals("0")) && (!parammii.jdField_a_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Mho.a(paramLong, parammii);
  }
  
  void a(View paramView, mii parammii, int paramInt)
  {
    if (paramView == null) {}
    do
    {
      return;
      paramView = paramView.findViewById(2131373372);
    } while ((paramView == null) || (parammii == null));
    paramView.setContentDescription(parammii.d);
    ViewCompat.setAccessibilityDelegate(paramView, new mhl(this, paramInt));
  }
  
  public void a(String paramString, int paramInt)
  {
    c(paramString, paramInt);
  }
  
  public void a(ArrayList<mii> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
  }
  
  public void a(mho parammho)
  {
    this.jdField_a_of_type_Mho = parammho;
  }
  
  public void a(mhp parammhp)
  {
    this.jdField_a_of_type_Mhp = parammhp;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    int i = this.d;
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    boolean bool1 = bool2;
    if (this.d != paramInt)
    {
      bool1 = bool2;
      if (paramInt >= 0)
      {
        bool1 = bool2;
        if (paramInt < j)
        {
          this.d = paramInt;
          notifyDataSetChanged();
          bool1 = true;
        }
      }
    }
    QLog.w("QAVPtvTemplateAdapter", 1, "setSelectedIndex, ret[" + bool1 + "], index[" + paramInt + "], mCurSelectedPosition[" + i + "->" + this.d + "], size[" + j + "]");
    return bool1;
  }
  
  public void b(String paramString, int paramInt)
  {
    mii localmii2 = null;
    int k = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
    int n = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition();
    int i = k;
    Object localObject;
    mii localmii1;
    for (;;)
    {
      if (i <= n) {
        if (i < 0)
        {
          i += 1;
        }
        else if (i >= this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localObject = null;
          localmii1 = localmii2;
        }
      }
    }
    for (;;)
    {
      label59:
      int j;
      label134:
      label145:
      if ((localmii1 == null) && (paramInt == 101))
      {
        int m = this.jdField_a_of_type_JavaUtilArrayList.size();
        j = 0;
        label82:
        if ((j < k) && (j < m))
        {
          localmii2 = (mii)this.jdField_a_of_type_JavaUtilArrayList.get(j);
          if ((localmii2 != null) && (localmii2.jdField_a_of_type_JavaLangString.equals(paramString)))
          {
            i = j;
            localmii1 = localmii2;
            if (localmii1 != null) {
              break label407;
            }
            j = n + 1;
            if (j >= m) {
              break label407;
            }
            localmii2 = (mii)this.jdField_a_of_type_JavaUtilArrayList.get(j);
            if ((localmii2 == null) || (!localmii2.jdField_a_of_type_JavaLangString.equals(paramString))) {
              break label355;
            }
            localmii1 = localmii2;
            i = j;
          }
        }
      }
      for (;;)
      {
        if (localmii1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("PtvTemplateManager", 2, String.format("onProgressUpdate, index[%s], [%s][%s], progress[%s]", new Object[] { Integer.valueOf(i), localmii1.jdField_a_of_type_JavaLangString, localmii1.c, Integer.valueOf(paramInt) }));
          }
          if (paramInt != -1) {
            break label364;
          }
          localmii1.jdField_b_of_type_Boolean = false;
        }
        for (;;)
        {
          if (localObject != null) {
            ((QavListItemBase)localObject).a(paramInt);
          }
          return;
          localmii1 = (mii)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if ((localmii1 == null) || (!localmii1.jdField_a_of_type_JavaLangString.equals(paramString))) {
            break;
          }
          localObject = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(i - k);
          if ((!(localObject instanceof QavListItemBase)) || (!this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getAdapter().equals(this))) {
            break label416;
          }
          localObject = (QavListItemBase)localObject;
          break label59;
          j += 1;
          break label82;
          label355:
          j += 1;
          break label145;
          label364:
          if (paramInt == 101)
          {
            localmii1.jdField_b_of_type_Boolean = false;
            localmii1.jdField_a_of_type_Boolean = true;
          }
          else
          {
            i = paramInt;
            if (paramInt == 100) {
              i = 99;
            }
            localmii1.jdField_b_of_type_Boolean = true;
            paramInt = i;
          }
        }
        label407:
        continue;
        break label134;
      }
      label416:
      localObject = null;
      continue;
      localObject = null;
      localmii1 = localmii2;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void c(String paramString, int paramInt)
  {
    ThreadManager.getUIHandler().post(new QAVPtvTemplateAdapter.7(this, paramString, paramInt));
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = null;
    boolean bool = true;
    mii localmii = a(paramInt);
    Object localObject1;
    if (localmii == null)
    {
      a(paramView, null, paramInt);
      localObject1 = paramView;
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
      if (!"-1".equals(localmii.jdField_a_of_type_JavaLangString)) {
        break;
      }
      localObject1 = localObject2;
      if (paramView != null)
      {
        localObject1 = localObject2;
        if (paramView.getId() == Integer.valueOf(localmii.jdField_a_of_type_JavaLangString).intValue()) {
          localObject1 = paramView;
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (this.jdField_a_of_type_AndroidViewView != null) {
          localObject2 = this.jdField_a_of_type_AndroidViewView;
        }
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new View(this.jdField_a_of_type_AndroidContentContext);
        ((View)localObject1).setId(Integer.valueOf(localmii.jdField_a_of_type_JavaLangString).intValue());
        ((View)localObject1).setLayoutParams(new AbsListView.LayoutParams(jdField_b_of_type_Int, -1));
        this.jdField_a_of_type_AndroidViewView = ((View)localObject1);
      }
      if (AudioHelper.a(0) == 1) {
        ((View)localObject1).setBackgroundColor(-256);
      }
    }
    label226:
    label237:
    int i;
    if (!(paramView instanceof QavListItemBase)) {
      if (localmii.jdField_a_of_type_Int == 2)
      {
        localObject1 = new VoiceChangeItemView2(this.jdField_a_of_type_AndroidContentContext);
        ((QavListItemBase)localObject1).a(jdField_a_of_type_Int, jdField_c_of_type_Int);
        if (AudioHelper.a(0) == 1)
        {
          ((QavListItemBase)localObject1).a(localmii, paramInt);
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setBackgroundColor(-1);
          QLog.w("QAVPtvTemplateAdapter", 1, "getView, itemView[" + localObject1.hashCode() + "], mListView[" + this.jdField_a_of_type_ComTencentWidgetHorizontalListView.hashCode() + "], position[" + paramInt + "], getPosition[" + ((QavListItemBase)localObject1).a() + "], mFullItemWidth[" + jdField_a_of_type_Int + "], mListViewHeight[" + jdField_c_of_type_Int + "], mListView.Height[" + this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getMeasuredHeight() + "|" + this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getHeight() + "], itemView.Height[" + ((QavListItemBase)localObject1).getMeasuredHeight() + "|" + ((QavListItemBase)localObject1).getHeight() + "], info[" + localmii + "]");
        }
        ((QavListItemBase)localObject1).b(jdField_a_of_type_Int, jdField_c_of_type_Int);
        if (paramInt != this.d) {
          break label567;
        }
        i = 1;
        label453:
        if ((!this.jdField_a_of_type_Boolean) || (i == 0)) {
          break label573;
        }
      }
    }
    for (;;)
    {
      ((QavListItemBase)localObject1).a(paramInt, bool, this.jdField_b_of_type_Boolean, localmii, this.jdField_a_of_type_Mig);
      a((View)localObject1, localmii, paramInt);
      break;
      localObject1 = new QavPtvTemplateItemView(this.jdField_a_of_type_AndroidContentContext);
      ((QavPtvTemplateItemView)localObject1).jdField_a_of_type_Boolean = this.jdField_c_of_type_Boolean;
      if (this.jdField_a_of_type_Float < 6.0F)
      {
        localObject2 = ((QavPtvTemplateItemView)localObject1).findViewById(2131373538);
        if ((localObject2 instanceof LinearLayout)) {
          ((LinearLayout)localObject2).setGravity(49);
        }
      }
      break label226;
      localObject1 = (QavListItemBase)paramView;
      break label237;
      label567:
      i = 0;
      break label453;
      label573:
      bool = false;
    }
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_AndroidViewView = null;
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mhi
 * JD-Core Version:    0.7.0.1
 */