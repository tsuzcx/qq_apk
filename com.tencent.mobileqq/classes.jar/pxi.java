import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommend;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowGroup;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowList;
import com.tencent.qphone.base.util.QLog;

public class pxi
{
  public static View a(int paramInt1, Object paramObject, int paramInt2, View paramView, Context paramContext, rqj paramrqj, bcws parambcws)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof pxl))) {}
    for (paramContext = (pxl)paramView.getTag();; paramContext = paramrqj)
    {
      if (paramContext != null)
      {
        paramContext.a(paramInt1).a(paramObject);
        paramContext.o();
        paramContext.p();
      }
      return paramView;
      paramrqj = a(paramInt2, paramContext, paramObject, parambcws, paramrqj);
      if (paramrqj != null) {
        try
        {
          paramView = paramrqj.a();
          paramView.setTag(paramrqj);
          if (!qfg.c(paramInt2)) {
            opi.a(paramView, paramContext.getResources().getDrawable(2130841380));
          } else {
            opi.a(paramView, paramContext.getResources().getDrawable(2131166790));
          }
        }
        catch (Exception paramObject)
        {
          QLog.e("CellFactory", 1, "getView: ", paramObject);
          return null;
        }
      }
    }
  }
  
  private static pxl a(int paramInt, Context paramContext, Object paramObject, bcws parambcws, rqj paramrqj)
  {
    switch (paramInt)
    {
    case 13: 
    case 38: 
    case 46: 
    case 70: 
    case 72: 
    case 73: 
    case 74: 
    case 75: 
    case 76: 
    case 77: 
    case 78: 
    case 79: 
    case 80: 
    case 81: 
    case 83: 
    case 84: 
    case 85: 
    case 86: 
    case 89: 
    case 90: 
    case 91: 
    case 92: 
    case 94: 
    case 95: 
    case 99: 
    case 100: 
    case 107: 
    case 108: 
    case 109: 
    case 110: 
    case 111: 
    case 112: 
    case 113: 
    case 114: 
    case 118: 
    case 119: 
    case 120: 
    case 121: 
    default: 
      paramContext = null;
    }
    for (;;)
    {
      if (paramContext != null) {}
      try
      {
        paramContext.a(paramObject);
        paramContext.a();
        paramContext.d();
        return paramContext;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
      paramContext = new pyy(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new qae(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new pxv(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new qao(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new qao(paramContext, parambcws, paramrqj);
      continue;
      paramContext = null;
      continue;
      paramContext = new qam(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new pxw(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new qad(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new pxu(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new qan(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new qaf(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new pyg(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new pyz(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new pxx(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new pyg(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new pzh(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new pzi(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new pye(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new pzr(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new pye(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new pzp(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new qbj(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new qbh(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new qbf(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new qbn(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new qbi(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new qbg(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new qbp(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new qbk(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new qbc(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new qap(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new pzz(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new qab(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new qbd(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new pzk(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new pzm(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new qas(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new qaw(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new qau(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new pxx(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new pzm(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new qaf(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new pym(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new pyv(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new pyn(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new qaz(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new qay(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new qba(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new qbk(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new qbi(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new qbp(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new pzt(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new pzu(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new pyw(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new pzv(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new pzx(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new pzw(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new qac(paramContext, parambcws, paramrqj, ComponentContentRecommend.class);
      continue;
      paramContext = new qac(paramContext, parambcws, paramrqj, ComponentContentRecommendFollowList.class);
      continue;
      paramContext = new qac(paramContext, parambcws, paramrqj, ComponentContentRecommendFollowGroup.class);
      continue;
      paramContext = new pyx(paramContext, parambcws, paramrqj);
      continue;
      paramContext = new pzg(paramContext, parambcws, paramrqj);
    }
    return null;
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool = true;
    switch (paramInt)
    {
    case 4: 
    case 13: 
    case 38: 
    case 46: 
    case 50: 
    case 51: 
    case 52: 
    case 70: 
    case 80: 
    case 81: 
    case 83: 
    case 84: 
    case 85: 
    case 86: 
    case 89: 
    case 90: 
    case 91: 
    case 92: 
    case 94: 
    case 95: 
    case 97: 
    case 98: 
    case 99: 
    case 100: 
    case 109: 
    case 110: 
    case 111: 
    case 112: 
    case 113: 
    case 114: 
    case 118: 
    case 119: 
    case 120: 
    case 121: 
    default: 
      bool = false;
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 5: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    case 31: 
    case 32: 
    case 33: 
    case 34: 
    case 35: 
    case 36: 
    case 37: 
    case 39: 
    case 40: 
    case 41: 
    case 42: 
    case 43: 
    case 44: 
    case 45: 
    case 47: 
    case 48: 
    case 49: 
    case 53: 
    case 54: 
    case 55: 
    case 56: 
    case 57: 
    case 58: 
    case 59: 
    case 60: 
    case 61: 
    case 62: 
    case 63: 
    case 64: 
    case 65: 
    case 66: 
    case 67: 
    case 68: 
    case 69: 
    case 71: 
    case 72: 
    case 73: 
    case 74: 
    case 75: 
    case 76: 
    case 77: 
    case 78: 
    case 79: 
    case 82: 
    case 87: 
    case 88: 
    case 93: 
    case 96: 
    case 101: 
    case 102: 
    case 103: 
    case 104: 
    case 105: 
    case 106: 
    case 107: 
    case 108: 
    case 115: 
    case 116: 
    case 117: 
    case 122: 
    case 123: 
      return bool;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pxi
 * JD-Core Version:    0.7.0.1
 */