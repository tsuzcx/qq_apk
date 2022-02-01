import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter.10;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter.3;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter.4;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter.5;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter.6;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter.7;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter.8;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter.9;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AuthorData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ssq
  extends BaseAdapter
  implements DownloadListener, stl, stm
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ssr(this);
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private List<BaseData> jdField_a_of_type_JavaUtilList;
  private sth[] jdField_a_of_type_ArrayOfSth;
  private float jdField_b_of_type_Float = 14.0F;
  private int jdField_b_of_type_Int = 16;
  private int c = 18;
  private int d = -1;
  
  public ssq(Context paramContext, List<BaseData> paramList, FaceDecoder paramFaceDecoder)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = paramFaceDecoder;
    f();
    g();
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
      QLog.d("WebFastAdapter", 1, paramView, new Object[] { " getItemMeasureHeight error! msg=" + paramView });
    }
    return 0;
  }
  
  public static String a(JSONObject paramJSONObject)
  {
    String str2 = "";
    String str1 = str2;
    if (paramJSONObject.opt("card_info") != null) {}
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("card_info");
      str1 = str2;
      if (paramJSONObject.opt("rowKey") != null) {
        str1 = paramJSONObject.getString("rowKey");
      }
      return str1;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return "";
  }
  
  private void f()
  {
    suo localsuo = new suo();
    svg localsvg = new svg(this.jdField_a_of_type_AndroidContentContext);
    sti localsti = new sti();
    this.jdField_a_of_type_ArrayOfSth = new sth[] { localsvg, new stp(), new stu(), new sug(), new tsz(), new suc(), new ttd(), new tth(), new ttl(), localsuo, localsti };
    localsuo.a(this);
    localsuo.a(this.jdField_a_of_type_AndroidContentContext);
    localsvg.f();
    localsti.a();
    bhyo.a().a(this);
  }
  
  private void g()
  {
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(String.valueOf(bkwm.a("local_kd_native_main_text_style")));
        localIterator = localJSONObject.keys();
        boolean bool = localIterator.hasNext();
        if (!bool) {}
      }
      catch (Exception localException1)
      {
        try
        {
          JSONObject localJSONObject;
          Iterator localIterator;
          String str1 = (String)localIterator.next();
          String str2 = localJSONObject.getString(str1);
          if ("native_main_text_color".equalsIgnoreCase(str1))
          {
            this.jdField_a_of_type_Int = Color.parseColor(str2);
            continue;
          }
          if ("native_main_text_size".equalsIgnoreCase(str1))
          {
            this.jdField_a_of_type_Float = Integer.valueOf(str2).intValue();
            this.jdField_a_of_type_Float = Utils.dp2px(Double.valueOf(this.jdField_a_of_type_Float).doubleValue());
            continue;
          }
          if ("native_main_text_row_space".equalsIgnoreCase(str1))
          {
            this.jdField_b_of_type_Float = Integer.valueOf(str2).intValue();
            continue;
          }
          if ("native_main_text_segment_space".equalsIgnoreCase(str1))
          {
            this.jdField_b_of_type_Int = Integer.valueOf(str2).intValue();
            continue;
          }
          if (!"native_main_text_margin_side".equalsIgnoreCase(str1)) {
            continue;
          }
          this.c = Integer.valueOf(str2).intValue();
        }
        catch (Exception localException2) {}
        localException1 = localException1;
      }
      return;
    }
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    BaseData localBaseData = (BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localBaseData == null)
    {
      AIOUtils.catchedExceptionInReleaseV2("Q.readinjoy.fast_web", "", new NullPointerException());
      paramView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    }
    do
    {
      do
      {
        do
        {
          return paramView;
          svv.a(localBaseData);
          try
          {
            localBaseData.s = paramInt;
            if (paramView != null) {
              break label291;
            }
            paramView = a(localBaseData);
            if (paramView == null) {
              break;
            }
            paramView = paramView.a(this.jdField_a_of_type_AndroidContentContext, localBaseData, paramViewGroup);
            paramView.a(this);
            paramViewGroup = paramView.jdField_a_of_type_AndroidViewView;
            paramViewGroup.setTag(paramView);
            localObject = paramView;
            paramView = paramViewGroup;
          }
          catch (Exception paramView)
          {
            for (;;)
            {
              QLog.d("WebFastAdapter", 1, "getView error,msg:" + paramView.toString());
              paramViewGroup = new View(this.jdField_a_of_type_AndroidContentContext);
              paramViewGroup.setVisibility(8);
              continue;
              paramViewGroup = (stg)paramView.getTag();
              Object localObject = paramViewGroup;
            }
          }
          ((stg)localObject).jdField_a_of_type_Float = this.jdField_a_of_type_Float;
          ((stg)localObject).jdField_b_of_type_Float = this.jdField_b_of_type_Float;
          ((stg)localObject).c = this.jdField_b_of_type_Int;
          ((stg)localObject).d = this.c;
          ((stg)localObject).jdField_b_of_type_Int = this.jdField_a_of_type_Int;
          ((stg)localObject).a(((stg)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, localBaseData, paramBoolean);
          paramViewGroup = paramView;
          if ((localBaseData instanceof AuthorData))
          {
            uhv.a(localBaseData.b, uhv.d, false);
            paramViewGroup = paramView;
          }
          paramView = paramViewGroup;
        } while (this.d <= 0);
        paramView = paramViewGroup;
      } while (localBaseData.t > 0);
      paramInt = a(paramInt, paramViewGroup);
      paramView = paramViewGroup;
    } while (paramInt <= 0);
    localBaseData.t = paramInt;
    return paramViewGroup;
    throw new NullPointerException();
  }
  
  public List<BaseData> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public sth a(BaseData paramBaseData)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfSth.length)
    {
      if (this.jdField_a_of_type_ArrayOfSth[i].a(paramBaseData)) {
        return this.jdField_a_of_type_ArrayOfSth[i];
      }
      i += 1;
    }
    throw new IllegalArgumentException("no suitable creator: " + paramBaseData.r);
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfSth.length)
    {
      if ((this.jdField_a_of_type_ArrayOfSth[i] instanceof stm)) {
        ((stm)this.jdField_a_of_type_ArrayOfSth[i]).a();
      }
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(BaseData paramBaseData) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfSth.length)
    {
      if ((this.jdField_a_of_type_ArrayOfSth[i] instanceof stm)) {
        ((stm)this.jdField_a_of_type_ArrayOfSth[i]).a(paramAbsListView, paramInt);
      }
      i += 1;
    }
  }
  
  public void b()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfSth.length)
    {
      if ((this.jdField_a_of_type_ArrayOfSth[i] instanceof stm)) {
        ((stm)this.jdField_a_of_type_ArrayOfSth[i]).b();
      }
      i += 1;
    }
  }
  
  public void c()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfSth.length)
    {
      if ((this.jdField_a_of_type_ArrayOfSth[i] instanceof stm)) {
        ((stm)this.jdField_a_of_type_ArrayOfSth[i]).c();
      }
      i += 1;
    }
  }
  
  public void d()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfSth.length)
    {
      if ((this.jdField_a_of_type_ArrayOfSth[i] instanceof stm)) {
        ((stm)this.jdField_a_of_type_ArrayOfSth[i]).d();
      }
      i += 1;
    }
    bhyo.a().b(this);
  }
  
  public void e()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfSth.length)
    {
      if ((this.jdField_a_of_type_ArrayOfSth[i] instanceof stm)) {
        ((stm)this.jdField_a_of_type_ArrayOfSth[i]).e();
      }
      i += 1;
    }
    bhyo.a().b(this);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return (BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return -1;
    }
    BaseData localBaseData = (BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    return a(localBaseData).a(localBaseData);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = a(paramInt, paramView, paramViewGroup, false);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return stg.jdField_a_of_type_Int;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ssq
 * JD-Core Version:    0.7.0.1
 */