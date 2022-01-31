import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommend;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowGroup;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowList;
import com.tencent.qphone.base.util.QLog;

public class pqq
{
  public static View a(int paramInt1, Object paramObject, int paramInt2, View paramView, Context paramContext, rap paramrap, baxk parambaxk)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof pqt))) {}
    for (paramContext = (pqt)paramView.getTag();; paramContext = paramrap)
    {
      if (paramContext != null)
      {
        paramContext.a(paramInt1).a(paramObject);
        paramContext.o();
        paramContext.p();
      }
      return paramView;
      paramrap = a(paramInt2, paramContext, paramObject, parambaxk, paramrap);
      if (paramrap != null) {
        try
        {
          paramView = paramrap.a();
          paramView.setTag(paramrap);
          if (!pyp.c(paramInt2)) {
            olb.a(paramView, paramContext.getResources().getDrawable(2130841265));
          } else {
            olb.a(paramView, paramContext.getResources().getDrawable(2131166743));
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
  
  private static pqt a(int paramInt, Context paramContext, Object paramObject, baxk parambaxk, rap paramrap)
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
      paramContext = new psh(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new ptn(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new prd(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new ptx(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new ptx(paramContext, parambaxk, paramrap);
      continue;
      paramContext = null;
      continue;
      paramContext = new ptv(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new pre(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new ptm(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new prc(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new ptw(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new pto(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new prp(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new psi(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new prf(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new prp(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new psq(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new psr(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new prm(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new pta(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new prm(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new psy(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new pus(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new puq(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new puo(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new puw(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new pur(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new pup(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new puy(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new put(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new pul(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new pty(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new pti(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new ptk(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new pum(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new pst(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new psv(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new pub(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new puf(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new pud(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new prf(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new psv(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new pto(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new prv(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new pse(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new prw(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new pui(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new puh(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new puj(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new put(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new pur(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new puy(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new ptc(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new ptd(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new psf(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new pte(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new ptg(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new ptf(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new ptl(paramContext, parambaxk, paramrap, ComponentContentRecommend.class);
      continue;
      paramContext = new ptl(paramContext, parambaxk, paramrap, ComponentContentRecommendFollowList.class);
      continue;
      paramContext = new ptl(paramContext, parambaxk, paramrap, ComponentContentRecommendFollowGroup.class);
      continue;
      paramContext = new psg(paramContext, parambaxk, paramrap);
      continue;
      paramContext = new psp(paramContext, parambaxk, paramrap);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pqq
 * JD-Core Version:    0.7.0.1
 */