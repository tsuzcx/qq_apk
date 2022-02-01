import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar.CommonAdBar;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusInnerData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class olr
{
  public static GradientDrawable a(Context paramContext, String paramString1, float paramFloat1, float paramFloat2, String paramString2)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(afur.a(paramFloat1, paramContext.getResources()));
    if (!TextUtils.isEmpty(paramString2)) {
      localGradientDrawable.setStroke(afur.a(paramFloat2, paramContext.getResources()), Color.parseColor(paramString2));
    }
    if (!TextUtils.isEmpty(paramString1)) {
      localGradientDrawable.setColor(Color.parseColor(paramString1));
    }
    return localGradientDrawable;
  }
  
  public static void a(Activity paramActivity, ArrayList<oln> paramArrayList, nxp paramnxp, CommonAdBar paramCommonAdBar, List<BaseData> paramList)
  {
    if ((paramActivity == null) || (paramnxp == null) || (paramCommonAdBar == null) || (paramList == null)) {
      return;
    }
    for (paramnxp = paramList.iterator();; paramnxp = (ProteusInnerData)paramList) {
      for (;;)
      {
        label26:
        if (paramnxp.hasNext())
        {
          paramList = (BaseData)paramnxp.next();
          if (((paramList instanceof ProteusInnerData)) && (paramList.f)) {
            if (!((ProteusInnerData)paramList).e()) {
              break;
            }
          }
        }
      }
    }
    for (;;)
    {
      label79:
      a(paramCommonAdBar, paramnxp);
      paramList = omg.a(paramActivity, paramnxp);
      if (paramList == null) {
        break;
      }
      paramCommonAdBar.a(paramList);
      orb localorb = orb.a(paramnxp);
      if (localorb == null) {
        break;
      }
      paramArrayList = paramArrayList.iterator();
      do
      {
        if (!paramArrayList.hasNext()) {
          break;
        }
        paramActivity = (oln)paramArrayList.next();
      } while ((paramActivity.a == null) || (!paramActivity.a.d.equals(localorb.d)));
      for (;;)
      {
        if (paramActivity == null) {
          break label216;
        }
        paramList.a(paramActivity);
        paramList.a(paramnxp);
        if (Build.VERSION.SDK_INT < 21) {
          break;
        }
        paramCommonAdBar.setElevation(9.0F);
        return;
        if (!((ProteusInnerData)paramList).f()) {
          break label26;
        }
        paramnxp = (ProteusInnerData)paramList;
        break label79;
        paramActivity = null;
      }
      label216:
      break;
      paramnxp = null;
    }
  }
  
  public static void a(Activity paramActivity, ArrayList<oln> paramArrayList, nxp paramnxp, List<BaseData> paramList)
  {
    if ((paramActivity == null) || (paramnxp == null) || (paramList == null)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BaseData localBaseData = (BaseData)paramList.next();
        if ((localBaseData instanceof AdData))
        {
          AdvertisementInfo localAdvertisementInfo = oqk.a((AdData)localBaseData);
          orb localorb = orb.a((AdData)localBaseData);
          oln localoln = new oln();
          localoln.a(paramActivity).a(paramnxp).a(localorb).a(localAdvertisementInfo).a((AdData)localBaseData);
          paramArrayList.add(localoln);
        }
      }
    }
  }
  
  public static void a(CommonAdBar paramCommonAdBar, AdData paramAdData)
  {
    if ((paramCommonAdBar == null) || (paramAdData == null)) {
      return;
    }
    paramCommonAdBar.a();
    ViewGroup.LayoutParams localLayoutParams = paramCommonAdBar.getLayoutParams();
    GradientDrawable localGradientDrawable;
    if (((paramAdData instanceof ProteusInnerData)) && (((ProteusInnerData)paramAdData).f()))
    {
      localLayoutParams.height = afur.a(64.0F, paramCommonAdBar.getResources());
      localGradientDrawable = a(paramCommonAdBar.getContext(), "#ffffff", 2.0F, 0.0F, "");
      paramAdData = localGradientDrawable;
      if (!(localLayoutParams instanceof RelativeLayout.LayoutParams)) {
        break label208;
      }
      ((RelativeLayout.LayoutParams)localLayoutParams).leftMargin = afur.a(12.0F, paramCommonAdBar.getResources());
      ((RelativeLayout.LayoutParams)localLayoutParams).rightMargin = afur.a(12.0F, paramCommonAdBar.getResources());
      paramAdData = localGradientDrawable;
    }
    for (;;)
    {
      paramCommonAdBar.setLayoutParams(localLayoutParams);
      if (paramAdData == null) {
        break;
      }
      paramCommonAdBar.setBackgroundDrawable(paramAdData);
      return;
      if (((paramAdData instanceof ProteusInnerData)) && (((ProteusInnerData)paramAdData).e()))
      {
        localLayoutParams.height = afur.a(46.0F, paramCommonAdBar.getResources());
        localGradientDrawable = a(paramCommonAdBar.getContext(), "#f7f7f7", 3.0F, 0.0F, "");
        paramAdData = localGradientDrawable;
        if ((localLayoutParams instanceof RelativeLayout.LayoutParams))
        {
          ((RelativeLayout.LayoutParams)localLayoutParams).leftMargin = afur.a(7.0F, paramCommonAdBar.getResources());
          ((RelativeLayout.LayoutParams)localLayoutParams).rightMargin = afur.a(7.0F, paramCommonAdBar.getResources());
          paramAdData = localGradientDrawable;
        }
      }
      else
      {
        label208:
        paramAdData = null;
      }
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return (!paramBoolean2) && (!paramBoolean3) && (paramBoolean1) && ((paramInt3 == 0) || (paramInt1 <= paramInt3)) && (paramInt1 * 2 >= paramInt2 * 3);
  }
  
  public static boolean a(omf paramomf)
  {
    if ((paramomf instanceof omb)) {
      return true;
    }
    return paramomf instanceof olx;
  }
  
  public static boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return (!paramBoolean1) && (paramBoolean2) && (!paramBoolean3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     olr
 * JD-Core Version:    0.7.0.1
 */