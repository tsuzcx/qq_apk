package com.tencent.mobileqq.kandian.biz.fastweb.adapter;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebAdService;
import com.tencent.mobileqq.kandian.biz.fastweb.IStateChangeListener;
import com.tencent.mobileqq.kandian.biz.fastweb.OnItemClickListener;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.biz.fastweb.item.NewPtsViewCreator;
import com.tencent.mobileqq.kandian.biz.fastweb.item.SimpleViewCreator;
import com.tencent.mobileqq.kandian.biz.fastweb.item.WebFastAttachedAdCreator;
import com.tencent.mobileqq.kandian.biz.fastweb.item.WebFastProteusViewCreator;
import com.tencent.mobileqq.kandian.biz.fastweb.item.WebProteusViewCreator;
import com.tencent.mobileqq.kandian.biz.fastweb.item.WebPtsLiteViewCreator;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebPTSUtils;
import com.tencent.mobileqq.kandian.biz.pts.ItemCreator;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.AuthorData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class WebFastAdapter
  extends BaseAdapter
  implements IStateChangeListener, OnItemClickListener, DownloadListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new WebFastAdapter.2(this);
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private BaseItemViewHolder jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEntityBaseItemViewHolder;
  private List<BaseData> jdField_a_of_type_JavaUtilList;
  private ItemCreator[] jdField_a_of_type_ArrayOfComTencentMobileqqKandianBizPtsItemCreator;
  private float jdField_b_of_type_Float = 14.0F;
  private int jdField_b_of_type_Int = 16;
  private int c = 18;
  private int d = -1;
  
  public WebFastAdapter(Context paramContext, List<BaseData> paramList, IFaceDecoder paramIFaceDecoder, VafContext paramVafContext)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = paramIFaceDecoder;
    a(paramVafContext);
    f();
  }
  
  private int a(int paramInt, View paramView)
  {
    try
    {
      paramView.measure(View.MeasureSpec.makeMeasureSpec(this.d, -2147483648), 0);
      paramInt = paramView.getMeasuredHeight();
      return paramInt;
    }
    catch (Exception paramView)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" getItemMeasureHeight error! msg=");
      localStringBuilder.append(paramView);
      QLog.d("WebFastAdapter", 1, paramView, new Object[] { localStringBuilder.toString() });
    }
    return 0;
  }
  
  public static String a(JSONObject paramJSONObject)
  {
    if (paramJSONObject.opt("card_info") != null) {
      try
      {
        paramJSONObject = paramJSONObject.getJSONObject("card_info");
        if (paramJSONObject.opt("rowKey") != null)
        {
          paramJSONObject = paramJSONObject.getString("rowKey");
          return paramJSONObject;
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
    return "";
  }
  
  private void a(VafContext paramVafContext)
  {
    paramVafContext = new WebProteusViewCreator(paramVafContext);
    WebPtsLiteViewCreator localWebPtsLiteViewCreator = new WebPtsLiteViewCreator(this.jdField_a_of_type_AndroidContentContext);
    NewPtsViewCreator localNewPtsViewCreator = new NewPtsViewCreator();
    ItemCreator[] arrayOfItemCreator1 = (ItemCreator[])((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).getWebFastProteusAdCreators();
    this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBizPtsItemCreator = new ItemCreator[arrayOfItemCreator1.length + 6];
    ItemCreator[] arrayOfItemCreator2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBizPtsItemCreator;
    int i = 0;
    arrayOfItemCreator2[0] = localWebPtsLiteViewCreator;
    arrayOfItemCreator2[1] = new SimpleViewCreator();
    this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBizPtsItemCreator[2] = new WebFastAttachedAdCreator();
    this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBizPtsItemCreator[3] = new WebFastProteusViewCreator();
    arrayOfItemCreator2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBizPtsItemCreator;
    arrayOfItemCreator2[4] = paramVafContext;
    arrayOfItemCreator2[5] = localNewPtsViewCreator;
    while (i < arrayOfItemCreator1.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBizPtsItemCreator[(i + 6)] = arrayOfItemCreator1[i];
      i += 1;
    }
    paramVafContext.a(this);
    localWebPtsLiteViewCreator.f();
    localNewPtsViewCreator.a();
    DownloadManagerV2.a().a(this);
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: new 112	org/json/JSONObject
    //   3: dup
    //   4: ldc 185
    //   6: ldc 131
    //   8: invokestatic 190	com/tencent/mobileqq/kandian/base/utils/RIJSPUtils:a	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   11: checkcast 192	java/lang/String
    //   14: invokespecial 195	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17: astore_2
    //   18: aload_2
    //   19: invokevirtual 199	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   22: astore_3
    //   23: aload_3
    //   24: invokeinterface 205 1 0
    //   29: istore_1
    //   30: iload_1
    //   31: ifeq +166 -> 197
    //   34: aload_3
    //   35: invokeinterface 209 1 0
    //   40: checkcast 192	java/lang/String
    //   43: astore 4
    //   45: aload_2
    //   46: aload 4
    //   48: invokevirtual 126	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   51: astore 5
    //   53: ldc 211
    //   55: aload 4
    //   57: invokevirtual 215	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   60: ifeq +15 -> 75
    //   63: aload_0
    //   64: aload 5
    //   66: invokestatic 221	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   69: putfield 223	com/tencent/mobileqq/kandian/biz/fastweb/adapter/WebFastAdapter:jdField_a_of_type_Int	I
    //   72: goto -49 -> 23
    //   75: ldc 225
    //   77: aload 4
    //   79: invokevirtual 215	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   82: ifeq +38 -> 120
    //   85: aload_0
    //   86: aload 5
    //   88: invokestatic 231	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   91: invokevirtual 234	java/lang/Integer:intValue	()I
    //   94: i2f
    //   95: putfield 236	com/tencent/mobileqq/kandian/biz/fastweb/adapter/WebFastAdapter:jdField_a_of_type_Float	F
    //   98: aload_0
    //   99: aload_0
    //   100: getfield 236	com/tencent/mobileqq/kandian/biz/fastweb/adapter/WebFastAdapter:jdField_a_of_type_Float	F
    //   103: f2d
    //   104: invokestatic 241	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   107: invokevirtual 245	java/lang/Double:doubleValue	()D
    //   110: invokestatic 251	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/Utils:dp2px	(D)I
    //   113: i2f
    //   114: putfield 236	com/tencent/mobileqq/kandian/biz/fastweb/adapter/WebFastAdapter:jdField_a_of_type_Float	F
    //   117: goto -94 -> 23
    //   120: ldc 253
    //   122: aload 4
    //   124: invokevirtual 215	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   127: ifeq +19 -> 146
    //   130: aload_0
    //   131: aload 5
    //   133: invokestatic 231	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   136: invokevirtual 234	java/lang/Integer:intValue	()I
    //   139: i2f
    //   140: putfield 31	com/tencent/mobileqq/kandian/biz/fastweb/adapter/WebFastAdapter:jdField_b_of_type_Float	F
    //   143: goto -120 -> 23
    //   146: ldc 255
    //   148: aload 4
    //   150: invokevirtual 215	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   153: ifeq +18 -> 171
    //   156: aload_0
    //   157: aload 5
    //   159: invokestatic 231	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   162: invokevirtual 234	java/lang/Integer:intValue	()I
    //   165: putfield 33	com/tencent/mobileqq/kandian/biz/fastweb/adapter/WebFastAdapter:jdField_b_of_type_Int	I
    //   168: goto -145 -> 23
    //   171: ldc_w 257
    //   174: aload 4
    //   176: invokevirtual 215	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   179: ifeq -156 -> 23
    //   182: aload_0
    //   183: aload 5
    //   185: invokestatic 231	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   188: invokevirtual 234	java/lang/Integer:intValue	()I
    //   191: putfield 35	com/tencent/mobileqq/kandian/biz/fastweb/adapter/WebFastAdapter:c	I
    //   194: goto -171 -> 23
    //   197: return
    //   198: astore_2
    //   199: return
    //   200: astore 4
    //   202: goto -179 -> 23
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	WebFastAdapter
    //   29	2	1	bool	boolean
    //   17	29	2	localJSONObject	JSONObject
    //   198	1	2	localException1	Exception
    //   22	13	3	localIterator	java.util.Iterator
    //   43	132	4	str1	String
    //   200	1	4	localException2	Exception
    //   51	133	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   0	23	198	java/lang/Exception
    //   23	30	198	java/lang/Exception
    //   34	72	200	java/lang/Exception
    //   75	117	200	java/lang/Exception
    //   120	143	200	java/lang/Exception
    //   146	168	200	java/lang/Exception
    //   171	194	200	java/lang/Exception
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    BaseData localBaseData = (BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localBaseData == null)
    {
      AIOUtils.a("Q.readinjoy.fast_web", "", new NullPointerException());
      return new TextView(this.jdField_a_of_type_AndroidContentContext);
    }
    FastWebPTSUtils.a(localBaseData);
    try
    {
      localBaseData.x = paramInt;
      if (paramView == null)
      {
        Object localObject = a(localBaseData);
        if (localObject != null)
        {
          localObject = ((ItemCreator)localObject).a(this.jdField_a_of_type_AndroidContentContext, localBaseData, paramViewGroup);
          paramViewGroup = (ViewGroup)localObject;
          if (localObject != null)
          {
            ((BaseItemViewHolder)localObject).a(this);
            paramView = ((BaseItemViewHolder)localObject).jdField_a_of_type_AndroidViewView;
            paramView.setTag(localObject);
            paramViewGroup = (ViewGroup)localObject;
          }
        }
        else
        {
          throw new NullPointerException();
        }
      }
      else
      {
        paramViewGroup = (BaseItemViewHolder)paramView.getTag();
      }
      if (paramViewGroup != null)
      {
        paramViewGroup.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
        paramViewGroup.jdField_b_of_type_Float = this.jdField_b_of_type_Float;
        paramViewGroup.c = this.jdField_b_of_type_Int;
        paramViewGroup.d = this.c;
        paramViewGroup.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
        paramViewGroup.b(paramViewGroup.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData, localBaseData, paramBoolean);
      }
      paramViewGroup = paramView;
      if ((localBaseData instanceof AuthorData))
      {
        ReadinjoyReportUtils.a(localBaseData.b, ReadinjoyReportUtils.d, false, "");
        paramViewGroup = paramView;
      }
    }
    catch (Exception paramView)
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("getView error,msg:");
      paramViewGroup.append(paramView.toString());
      QLog.d("WebFastAdapter", 1, paramViewGroup.toString());
      paramViewGroup = new View(this.jdField_a_of_type_AndroidContentContext);
      paramViewGroup.setVisibility(8);
    }
    if ((this.d > 0) && (localBaseData.y <= 0))
    {
      paramInt = a(paramInt, paramViewGroup);
      if (paramInt > 0) {
        localBaseData.y = paramInt;
      }
    }
    return paramViewGroup;
  }
  
  public ItemCreator a(BaseData paramBaseData)
  {
    int i = 0;
    for (;;)
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBizPtsItemCreator;
      if (i >= localObject.length) {
        break;
      }
      if (localObject[i].a(paramBaseData)) {
        return this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBizPtsItemCreator[i];
      }
      i += 1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("no suitable creator: ");
    ((StringBuilder)localObject).append(paramBaseData.u);
    paramBaseData = new IllegalArgumentException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw paramBaseData;
    }
  }
  
  public List<BaseData> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    int i = 0;
    for (;;)
    {
      ItemCreator[] arrayOfItemCreator = this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBizPtsItemCreator;
      if (i >= arrayOfItemCreator.length) {
        break;
      }
      if ((arrayOfItemCreator[i] instanceof IStateChangeListener)) {
        ((IStateChangeListener)arrayOfItemCreator[i]).a();
      }
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(BaseItemViewHolder paramBaseItemViewHolder)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebEntityBaseItemViewHolder = paramBaseItemViewHolder;
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(0, HardCodeUtil.a(2131716359));
    BubbleContextMenu.a(paramBaseItemViewHolder.jdField_a_of_type_AndroidViewView, localQQCustomMenu, this.jdField_a_of_type_AndroidViewView$OnClickListener, new WebFastAdapter.1(this, paramBaseItemViewHolder));
  }
  
  public void a(BaseData paramBaseData) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    int i = 0;
    for (;;)
    {
      ItemCreator[] arrayOfItemCreator = this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBizPtsItemCreator;
      if (i >= arrayOfItemCreator.length) {
        break;
      }
      if ((arrayOfItemCreator[i] instanceof IStateChangeListener)) {
        ((IStateChangeListener)arrayOfItemCreator[i]).a(paramAbsListView, paramInt);
      }
      i += 1;
    }
  }
  
  public void b()
  {
    int i = 0;
    for (;;)
    {
      ItemCreator[] arrayOfItemCreator = this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBizPtsItemCreator;
      if (i >= arrayOfItemCreator.length) {
        break;
      }
      if ((arrayOfItemCreator[i] instanceof IStateChangeListener)) {
        ((IStateChangeListener)arrayOfItemCreator[i]).b();
      }
      i += 1;
    }
  }
  
  public void c()
  {
    int i = 0;
    for (;;)
    {
      ItemCreator[] arrayOfItemCreator = this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBizPtsItemCreator;
      if (i >= arrayOfItemCreator.length) {
        break;
      }
      if ((arrayOfItemCreator[i] instanceof IStateChangeListener)) {
        ((IStateChangeListener)arrayOfItemCreator[i]).c();
      }
      i += 1;
    }
  }
  
  public void d()
  {
    int i = 0;
    for (;;)
    {
      ItemCreator[] arrayOfItemCreator = this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBizPtsItemCreator;
      if (i >= arrayOfItemCreator.length) {
        break;
      }
      if ((arrayOfItemCreator[i] instanceof IStateChangeListener)) {
        ((IStateChangeListener)arrayOfItemCreator[i]).d();
      }
      i += 1;
    }
    DownloadManagerV2.a().b(this);
  }
  
  public void e()
  {
    int i = 0;
    for (;;)
    {
      ItemCreator[] arrayOfItemCreator = this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBizPtsItemCreator;
      if (i >= arrayOfItemCreator.length) {
        break;
      }
      if ((arrayOfItemCreator[i] instanceof IStateChangeListener)) {
        ((IStateChangeListener)arrayOfItemCreator[i]).e();
      }
      i += 1;
    }
    DownloadManagerV2.a().b(this);
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (paramInt >= 0) && (paramInt < ((List)localObject).size()))
    {
      localObject = (BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      return a((BaseData)localObject).a((BaseData)localObject);
    }
    return -1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return a(paramInt, paramView, paramViewGroup, false);
  }
  
  public int getViewTypeCount()
  {
    return BaseItemViewHolder.jdField_a_of_type_Int;
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if (!"com.tencent.reading".equals(paramString2)) {
      return;
    }
    ThreadManager.getUIHandler().post(new WebFastAdapter.9(this));
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getUIHandler().post(new WebFastAdapter.6(this, paramDownloadInfo));
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new WebFastAdapter.8(this, paramDownloadInfo));
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getUIHandler().post(new WebFastAdapter.5(this, paramDownloadInfo));
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getUIHandler().post(new WebFastAdapter.3(this, paramDownloadInfo));
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    ThreadManager.getUIHandler().post(new WebFastAdapter.7(this, paramList));
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getUIHandler().post(new WebFastAdapter.4(this, paramDownloadInfo));
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    if (!"com.tencent.reading".equals(paramString2)) {
      return;
    }
    ThreadManager.getUIHandler().post(new WebFastAdapter.10(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.adapter.WebFastAdapter
 * JD-Core Version:    0.7.0.1
 */