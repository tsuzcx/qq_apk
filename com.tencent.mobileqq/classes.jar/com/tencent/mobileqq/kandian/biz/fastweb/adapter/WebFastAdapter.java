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
  View.OnClickListener a = new WebFastAdapter.2(this);
  private List<BaseData> b;
  private Context c;
  private IFaceDecoder d;
  private BaseItemViewHolder e;
  private ItemCreator[] f;
  private float g;
  private float h = 14.0F;
  private int i;
  private int j = 16;
  private int k = 18;
  private int l = -1;
  
  public WebFastAdapter(Context paramContext, List<BaseData> paramList, IFaceDecoder paramIFaceDecoder, VafContext paramVafContext)
  {
    this.b = paramList;
    this.c = paramContext;
    this.d = paramIFaceDecoder;
    a(paramVafContext);
    g();
  }
  
  private int a(int paramInt, View paramView)
  {
    try
    {
      paramView.measure(View.MeasureSpec.makeMeasureSpec(this.l, -2147483648), 0);
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
    WebPtsLiteViewCreator localWebPtsLiteViewCreator = new WebPtsLiteViewCreator(this.c);
    NewPtsViewCreator localNewPtsViewCreator = new NewPtsViewCreator();
    ItemCreator[] arrayOfItemCreator1 = (ItemCreator[])((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).getWebFastProteusAdCreators();
    this.f = new ItemCreator[arrayOfItemCreator1.length + 6];
    ItemCreator[] arrayOfItemCreator2 = this.f;
    int m = 0;
    arrayOfItemCreator2[0] = localWebPtsLiteViewCreator;
    arrayOfItemCreator2[1] = new SimpleViewCreator();
    this.f[2] = new WebFastAttachedAdCreator();
    this.f[3] = new WebFastProteusViewCreator();
    arrayOfItemCreator2 = this.f;
    arrayOfItemCreator2[4] = paramVafContext;
    arrayOfItemCreator2[5] = localNewPtsViewCreator;
    while (m < arrayOfItemCreator1.length)
    {
      this.f[(m + 6)] = arrayOfItemCreator1[m];
      m += 1;
    }
    paramVafContext.a(this);
    localWebPtsLiteViewCreator.f();
    localNewPtsViewCreator.a();
    DownloadManagerV2.a().a(this);
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: new 119	org/json/JSONObject
    //   3: dup
    //   4: ldc 193
    //   6: ldc 138
    //   8: invokestatic 198	com/tencent/mobileqq/kandian/base/utils/RIJSPUtils:b	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   11: checkcast 200	java/lang/String
    //   14: invokespecial 203	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   17: astore_2
    //   18: aload_2
    //   19: invokevirtual 207	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   22: astore_3
    //   23: aload_3
    //   24: invokeinterface 213 1 0
    //   29: istore_1
    //   30: iload_1
    //   31: ifeq +168 -> 199
    //   34: aload_3
    //   35: invokeinterface 217 1 0
    //   40: checkcast 200	java/lang/String
    //   43: astore 4
    //   45: aload_2
    //   46: aload 4
    //   48: invokevirtual 133	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   51: astore 5
    //   53: ldc 219
    //   55: aload 4
    //   57: invokevirtual 223	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   60: ifeq +15 -> 75
    //   63: aload_0
    //   64: aload 5
    //   66: invokestatic 229	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   69: putfield 231	com/tencent/mobileqq/kandian/biz/fastweb/adapter/WebFastAdapter:i	I
    //   72: goto -49 -> 23
    //   75: ldc 233
    //   77: aload 4
    //   79: invokevirtual 223	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   82: ifeq +38 -> 120
    //   85: aload_0
    //   86: aload 5
    //   88: invokestatic 239	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   91: invokevirtual 242	java/lang/Integer:intValue	()I
    //   94: i2f
    //   95: putfield 244	com/tencent/mobileqq/kandian/biz/fastweb/adapter/WebFastAdapter:g	F
    //   98: aload_0
    //   99: aload_0
    //   100: getfield 244	com/tencent/mobileqq/kandian/biz/fastweb/adapter/WebFastAdapter:g	F
    //   103: f2d
    //   104: invokestatic 249	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   107: invokevirtual 253	java/lang/Double:doubleValue	()D
    //   110: invokestatic 259	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/Utils:dp2px	(D)I
    //   113: i2f
    //   114: putfield 244	com/tencent/mobileqq/kandian/biz/fastweb/adapter/WebFastAdapter:g	F
    //   117: goto -94 -> 23
    //   120: ldc_w 261
    //   123: aload 4
    //   125: invokevirtual 223	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   128: ifeq +19 -> 147
    //   131: aload_0
    //   132: aload 5
    //   134: invokestatic 239	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   137: invokevirtual 242	java/lang/Integer:intValue	()I
    //   140: i2f
    //   141: putfield 39	com/tencent/mobileqq/kandian/biz/fastweb/adapter/WebFastAdapter:h	F
    //   144: goto -121 -> 23
    //   147: ldc_w 263
    //   150: aload 4
    //   152: invokevirtual 223	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   155: ifeq +18 -> 173
    //   158: aload_0
    //   159: aload 5
    //   161: invokestatic 239	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   164: invokevirtual 242	java/lang/Integer:intValue	()I
    //   167: putfield 41	com/tencent/mobileqq/kandian/biz/fastweb/adapter/WebFastAdapter:j	I
    //   170: goto -147 -> 23
    //   173: ldc_w 265
    //   176: aload 4
    //   178: invokevirtual 223	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   181: ifeq -158 -> 23
    //   184: aload_0
    //   185: aload 5
    //   187: invokestatic 239	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   190: invokevirtual 242	java/lang/Integer:intValue	()I
    //   193: putfield 43	com/tencent/mobileqq/kandian/biz/fastweb/adapter/WebFastAdapter:k	I
    //   196: goto -173 -> 23
    //   199: return
    //   200: astore_2
    //   201: return
    //   202: astore 4
    //   204: goto -181 -> 23
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	WebFastAdapter
    //   29	2	1	bool	boolean
    //   17	29	2	localJSONObject	JSONObject
    //   200	1	2	localException1	Exception
    //   22	13	3	localIterator	java.util.Iterator
    //   43	134	4	str1	String
    //   202	1	4	localException2	Exception
    //   51	135	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   0	23	200	java/lang/Exception
    //   23	30	200	java/lang/Exception
    //   34	72	202	java/lang/Exception
    //   75	117	202	java/lang/Exception
    //   120	144	202	java/lang/Exception
    //   147	170	202	java/lang/Exception
    //   173	196	202	java/lang/Exception
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    BaseData localBaseData = (BaseData)this.b.get(paramInt);
    if (localBaseData == null)
    {
      AIOUtils.a("Q.readinjoy.fast_web", "", new NullPointerException());
      return new TextView(this.c);
    }
    FastWebPTSUtils.b(localBaseData);
    try
    {
      localBaseData.aX = paramInt;
      if (paramView == null)
      {
        Object localObject = b(localBaseData);
        if (localObject != null)
        {
          localObject = ((ItemCreator)localObject).a(this.c, localBaseData, paramViewGroup);
          paramViewGroup = (ViewGroup)localObject;
          if (localObject != null)
          {
            ((BaseItemViewHolder)localObject).a(this);
            paramView = ((BaseItemViewHolder)localObject).f;
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
        paramViewGroup.i = this.g;
        paramViewGroup.j = this.h;
        paramViewGroup.l = this.j;
        paramViewGroup.m = this.k;
        paramViewGroup.k = this.i;
        paramViewGroup.b(paramViewGroup.g, localBaseData, paramBoolean);
      }
      paramViewGroup = paramView;
      if ((localBaseData instanceof AuthorData))
      {
        ReadinjoyReportUtils.a(localBaseData.aQ, ReadinjoyReportUtils.d, false, "");
        paramViewGroup = paramView;
      }
    }
    catch (Exception paramView)
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("getView error,msg:");
      paramViewGroup.append(paramView.toString());
      QLog.d("WebFastAdapter", 1, paramViewGroup.toString());
      paramViewGroup = new View(this.c);
      paramViewGroup.setVisibility(8);
    }
    if ((this.l > 0) && (localBaseData.aY <= 0))
    {
      paramInt = a(paramInt, paramViewGroup);
      if (paramInt > 0) {
        localBaseData.aY = paramInt;
      }
    }
    return paramViewGroup;
  }
  
  public void a()
  {
    int m = 0;
    for (;;)
    {
      ItemCreator[] arrayOfItemCreator = this.f;
      if (m >= arrayOfItemCreator.length) {
        break;
      }
      if ((arrayOfItemCreator[m] instanceof IStateChangeListener)) {
        ((IStateChangeListener)arrayOfItemCreator[m]).a();
      }
      m += 1;
    }
  }
  
  public void a(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void a(BaseItemViewHolder paramBaseItemViewHolder)
  {
    this.e = paramBaseItemViewHolder;
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(0, HardCodeUtil.a(2131913800));
    BubbleContextMenu.a(paramBaseItemViewHolder.f, localQQCustomMenu, this.a, new WebFastAdapter.1(this, paramBaseItemViewHolder));
  }
  
  public void a(BaseData paramBaseData) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    int m = 0;
    for (;;)
    {
      ItemCreator[] arrayOfItemCreator = this.f;
      if (m >= arrayOfItemCreator.length) {
        break;
      }
      if ((arrayOfItemCreator[m] instanceof IStateChangeListener)) {
        ((IStateChangeListener)arrayOfItemCreator[m]).a(paramAbsListView, paramInt);
      }
      m += 1;
    }
  }
  
  public ItemCreator b(BaseData paramBaseData)
  {
    int m = 0;
    for (;;)
    {
      localObject = this.f;
      if (m >= localObject.length) {
        break;
      }
      if (localObject[m].a(paramBaseData)) {
        return this.f[m];
      }
      m += 1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("no suitable creator: ");
    ((StringBuilder)localObject).append(paramBaseData.aP);
    paramBaseData = new IllegalArgumentException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw paramBaseData;
    }
  }
  
  public void b()
  {
    int m = 0;
    for (;;)
    {
      ItemCreator[] arrayOfItemCreator = this.f;
      if (m >= arrayOfItemCreator.length) {
        break;
      }
      if ((arrayOfItemCreator[m] instanceof IStateChangeListener)) {
        ((IStateChangeListener)arrayOfItemCreator[m]).b();
      }
      m += 1;
    }
  }
  
  public void c()
  {
    int m = 0;
    for (;;)
    {
      ItemCreator[] arrayOfItemCreator = this.f;
      if (m >= arrayOfItemCreator.length) {
        break;
      }
      if ((arrayOfItemCreator[m] instanceof IStateChangeListener)) {
        ((IStateChangeListener)arrayOfItemCreator[m]).c();
      }
      m += 1;
    }
  }
  
  public void d()
  {
    int m = 0;
    for (;;)
    {
      ItemCreator[] arrayOfItemCreator = this.f;
      if (m >= arrayOfItemCreator.length) {
        break;
      }
      if ((arrayOfItemCreator[m] instanceof IStateChangeListener)) {
        ((IStateChangeListener)arrayOfItemCreator[m]).d();
      }
      m += 1;
    }
    DownloadManagerV2.a().b(this);
  }
  
  public void e()
  {
    int m = 0;
    for (;;)
    {
      ItemCreator[] arrayOfItemCreator = this.f;
      if (m >= arrayOfItemCreator.length) {
        break;
      }
      if ((arrayOfItemCreator[m] instanceof IStateChangeListener)) {
        ((IStateChangeListener)arrayOfItemCreator[m]).e();
      }
      m += 1;
    }
    DownloadManagerV2.a().b(this);
  }
  
  public List<BaseData> f()
  {
    return this.b;
  }
  
  public int getCount()
  {
    List localList = this.b;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.b;
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
    Object localObject = this.b;
    if ((localObject != null) && (paramInt >= 0) && (paramInt < ((List)localObject).size()))
    {
      localObject = (BaseData)this.b.get(paramInt);
      return b((BaseData)localObject).b((BaseData)localObject);
    }
    return -1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return a(paramInt, paramView, paramViewGroup, false);
  }
  
  public int getViewTypeCount()
  {
    return BaseItemViewHolder.e;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.adapter.WebFastAdapter
 * JD-Core Version:    0.7.0.1
 */