import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommend;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowGroup;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowList;
import com.tencent.qphone.base.util.QLog;

public class pqn
{
  public static View a(int paramInt1, Object paramObject, int paramInt2, View paramView, Context paramContext, ram paramram, baxy parambaxy)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof pqq))) {}
    for (paramContext = (pqq)paramView.getTag();; paramContext = paramram)
    {
      if (paramContext != null)
      {
        paramContext.a(paramInt1).a(paramObject);
        paramContext.o();
        paramContext.p();
      }
      return paramView;
      paramram = a(paramInt2, paramContext, paramObject, parambaxy, paramram);
      if (paramram != null) {
        try
        {
          paramView = paramram.a();
          paramView.setTag(paramram);
          if (!pym.c(paramInt2)) {
            oky.a(paramView, paramContext.getResources().getDrawable(2130841262));
          } else {
            oky.a(paramView, paramContext.getResources().getDrawable(2131166743));
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
  
  private static pqq a(int paramInt, Context paramContext, Object paramObject, baxy parambaxy, ram paramram)
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
      paramContext = new pse(paramContext, parambaxy, paramram);
      continue;
      paramContext = new ptk(paramContext, parambaxy, paramram);
      continue;
      paramContext = new pra(paramContext, parambaxy, paramram);
      continue;
      paramContext = new ptu(paramContext, parambaxy, paramram);
      continue;
      paramContext = new ptu(paramContext, parambaxy, paramram);
      continue;
      paramContext = null;
      continue;
      paramContext = new pts(paramContext, parambaxy, paramram);
      continue;
      paramContext = new prb(paramContext, parambaxy, paramram);
      continue;
      paramContext = new ptj(paramContext, parambaxy, paramram);
      continue;
      paramContext = new pqz(paramContext, parambaxy, paramram);
      continue;
      paramContext = new ptt(paramContext, parambaxy, paramram);
      continue;
      paramContext = new ptl(paramContext, parambaxy, paramram);
      continue;
      paramContext = new prl(paramContext, parambaxy, paramram);
      continue;
      paramContext = new psf(paramContext, parambaxy, paramram);
      continue;
      paramContext = new prc(paramContext, parambaxy, paramram);
      continue;
      paramContext = new prl(paramContext, parambaxy, paramram);
      continue;
      paramContext = new psn(paramContext, parambaxy, paramram);
      continue;
      paramContext = new pso(paramContext, parambaxy, paramram);
      continue;
      paramContext = new prj(paramContext, parambaxy, paramram);
      continue;
      paramContext = new psx(paramContext, parambaxy, paramram);
      continue;
      paramContext = new prj(paramContext, parambaxy, paramram);
      continue;
      paramContext = new psv(paramContext, parambaxy, paramram);
      continue;
      paramContext = new pup(paramContext, parambaxy, paramram);
      continue;
      paramContext = new pun(paramContext, parambaxy, paramram);
      continue;
      paramContext = new pul(paramContext, parambaxy, paramram);
      continue;
      paramContext = new put(paramContext, parambaxy, paramram);
      continue;
      paramContext = new puo(paramContext, parambaxy, paramram);
      continue;
      paramContext = new pum(paramContext, parambaxy, paramram);
      continue;
      paramContext = new puv(paramContext, parambaxy, paramram);
      continue;
      paramContext = new puq(paramContext, parambaxy, paramram);
      continue;
      paramContext = new pui(paramContext, parambaxy, paramram);
      continue;
      paramContext = new ptv(paramContext, parambaxy, paramram);
      continue;
      paramContext = new ptf(paramContext, parambaxy, paramram);
      continue;
      paramContext = new pth(paramContext, parambaxy, paramram);
      continue;
      paramContext = new puj(paramContext, parambaxy, paramram);
      continue;
      paramContext = new psq(paramContext, parambaxy, paramram);
      continue;
      paramContext = new pss(paramContext, parambaxy, paramram);
      continue;
      paramContext = new pty(paramContext, parambaxy, paramram);
      continue;
      paramContext = new puc(paramContext, parambaxy, paramram);
      continue;
      paramContext = new pua(paramContext, parambaxy, paramram);
      continue;
      paramContext = new prc(paramContext, parambaxy, paramram);
      continue;
      paramContext = new pss(paramContext, parambaxy, paramram);
      continue;
      paramContext = new ptl(paramContext, parambaxy, paramram);
      continue;
      paramContext = new prs(paramContext, parambaxy, paramram);
      continue;
      paramContext = new psb(paramContext, parambaxy, paramram);
      continue;
      paramContext = new prt(paramContext, parambaxy, paramram);
      continue;
      paramContext = new puf(paramContext, parambaxy, paramram);
      continue;
      paramContext = new pue(paramContext, parambaxy, paramram);
      continue;
      paramContext = new pug(paramContext, parambaxy, paramram);
      continue;
      paramContext = new puq(paramContext, parambaxy, paramram);
      continue;
      paramContext = new puo(paramContext, parambaxy, paramram);
      continue;
      paramContext = new puv(paramContext, parambaxy, paramram);
      continue;
      paramContext = new psz(paramContext, parambaxy, paramram);
      continue;
      paramContext = new pta(paramContext, parambaxy, paramram);
      continue;
      paramContext = new psc(paramContext, parambaxy, paramram);
      continue;
      paramContext = new ptb(paramContext, parambaxy, paramram);
      continue;
      paramContext = new ptd(paramContext, parambaxy, paramram);
      continue;
      paramContext = new ptc(paramContext, parambaxy, paramram);
      continue;
      paramContext = new pti(paramContext, parambaxy, paramram, ComponentContentRecommend.class);
      continue;
      paramContext = new pti(paramContext, parambaxy, paramram, ComponentContentRecommendFollowList.class);
      continue;
      paramContext = new pti(paramContext, parambaxy, paramram, ComponentContentRecommendFollowGroup.class);
      continue;
      paramContext = new psd(paramContext, parambaxy, paramram);
      continue;
      paramContext = new psm(paramContext, parambaxy, paramram);
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
 * Qualified Name:     pqn
 * JD-Core Version:    0.7.0.1
 */