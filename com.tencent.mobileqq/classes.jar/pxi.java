import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommend;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowGroup;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowList;
import com.tencent.qphone.base.util.QLog;

public class pxi
{
  public static View a(int paramInt1, Object paramObject, int paramInt2, View paramView, Context paramContext, rqj paramrqj, bdbb parambdbb)
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
      paramrqj = a(paramInt2, paramContext, paramObject, parambdbb, paramrqj);
      if (paramrqj != null) {
        try
        {
          paramView = paramrqj.a();
          paramView.setTag(paramrqj);
          if (!qfg.c(paramInt2)) {
            opi.a(paramView, paramContext.getResources().getDrawable(2130841381));
          } else {
            opi.a(paramView, paramContext.getResources().getDrawable(2131166792));
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
  
  private static pxl a(int paramInt, Context paramContext, Object paramObject, bdbb parambdbb, rqj paramrqj)
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
      paramContext = new pyy(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new qae(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new pxv(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new qao(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new qao(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = null;
      continue;
      paramContext = new qam(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new pxw(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new qad(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new pxu(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new qan(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new qaf(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new pyg(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new pyz(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new pxx(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new pyg(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new pzh(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new pzi(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new pye(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new pzr(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new pye(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new pzp(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new qbj(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new qbh(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new qbf(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new qbn(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new qbi(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new qbg(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new qbp(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new qbk(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new qbc(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new qap(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new pzz(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new qab(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new qbd(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new pzk(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new pzm(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new qas(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new qaw(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new qau(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new pxx(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new pzm(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new qaf(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new pym(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new pyv(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new pyn(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new qaz(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new qay(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new qba(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new qbk(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new qbi(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new qbp(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new pzt(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new pzu(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new pyw(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new pzv(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new pzx(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new pzw(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new qac(paramContext, parambdbb, paramrqj, ComponentContentRecommend.class);
      continue;
      paramContext = new qac(paramContext, parambdbb, paramrqj, ComponentContentRecommendFollowList.class);
      continue;
      paramContext = new qac(paramContext, parambdbb, paramrqj, ComponentContentRecommendFollowGroup.class);
      continue;
      paramContext = new pyx(paramContext, parambdbb, paramrqj);
      continue;
      paramContext = new pzg(paramContext, parambdbb, paramrqj);
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