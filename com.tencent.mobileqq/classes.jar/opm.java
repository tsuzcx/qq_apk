import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;

public class opm
{
  private static final int a = Utils.rp2px(8.0D);
  
  private static int a(TemplateBean paramTemplateBean)
  {
    if (paramTemplateBean == null)
    {
      QLog.i("DividerConfigUtils", 1, "templateBean TYPE_UNKNOW == null");
      return -1;
    }
    if (paramTemplateBean.findViewById("id_separator_normal_bottom") != null) {
      return 1;
    }
    if (paramTemplateBean.findViewById("id_separator_special_bottom_line") != null) {
      return 2;
    }
    if (paramTemplateBean.findViewById("id_separator_special_color_bottom") != null) {
      return 3;
    }
    QLog.i("DividerConfigUtils", 1, "getViewType TYPE_UNKNOW" + paramTemplateBean);
    return -1;
  }
  
  private static int a(ViewBase paramViewBase, boolean paramBoolean)
  {
    if (paramViewBase == null) {
      return 0;
    }
    Layout.Params localParams = paramViewBase.getComLayoutParams();
    int i = localParams.mLayoutHeight;
    if (paramBoolean) {}
    for (localParams.mLayoutHeight = a;; localParams.mLayoutHeight = 0)
    {
      paramViewBase.setComLayoutParams(localParams);
      return localParams.mLayoutHeight - i;
    }
  }
  
  public static boolean a(Container paramContainer, pgd parampgd)
  {
    if ((paramContainer == null) || (parampgd == null)) {}
    rqj localrqj;
    int k;
    Object localObject2;
    int i;
    do
    {
      do
      {
        do
        {
          return false;
          localrqj = parampgd.a();
        } while (localrqj == null);
        k = parampgd.g();
        localObject1 = localrqj.b(k);
        localObject2 = localrqj.b(k + 1);
      } while ((localObject1 == null) || (localObject2 == null));
      i = a(((BaseArticleInfo)localObject1).mProteusTemplateBean);
    } while (i == -1);
    int j = a(((BaseArticleInfo)localObject2).mProteusTemplateBean);
    QLog.i("DividerConfigUtils", 1, "topType:" + i + " nextType:" + j);
    if (j < 0) {
      QLog.i("DividerConfigUtils", 1, "nextArticleInfo:" + ((BaseArticleInfo)localObject2).mProteusTemplateBean);
    }
    Object localObject1 = paramContainer.getVirtualView();
    ViewBase localViewBase;
    switch (i)
    {
    default: 
      i = 0;
    case 1: 
      for (;;)
      {
        parampgd = ((ViewBase)localObject1).getComLayoutParams();
        if (parampgd.mLayoutHeight >= 0) {
          parampgd.mLayoutHeight = (i + parampgd.mLayoutHeight);
        }
        parampgd = ((ViewBase)localObject1).getComLayoutParams();
        paramContainer.setLayoutParams(new RelativeLayout.LayoutParams(parampgd.mLayoutWidth, parampgd.mLayoutHeight));
        return true;
        parampgd = ((ViewBase)localObject1).findViewBaseByName("id_separator_normal_bottom");
        switch (j)
        {
        default: 
          i = a(parampgd, false);
          break;
        case 2: 
        case 3: 
          i = a(parampgd, true);
        }
      }
    case 2: 
      localObject2 = ((ViewBase)localObject1).findViewBaseByName("id_separator_special_bottom_space");
      localViewBase = ((ViewBase)localObject1).findViewBaseByName("id_separator_special_bottom_line");
      switch (j)
      {
      default: 
        if (parampgd.e() != 70) {}
        break;
      }
      break;
    }
    for (boolean bool = false;; bool = true)
    {
      i = a((ViewBase)localObject2, bool);
      j = b(localViewBase, bool) + (i + 0);
      for (;;)
      {
        i = k - 1;
        if (i < 0) {
          break label456;
        }
        parampgd = localrqj.b(i);
        i = j;
        if (parampgd == null) {
          break;
        }
        i = j;
        if (a(parampgd.mProteusTemplateBean) != 3) {
          break;
        }
        i = j + b(((ViewBase)localObject1).findViewBaseByName("id_separator_special_top"), false);
        break;
        j = a((ViewBase)localObject2, false) + 0 + b(localViewBase, false);
        continue;
        j = a((ViewBase)localObject2, true) + 0 + b(localViewBase, true);
      }
      label456:
      i = j;
      if (k != 0) {
        break;
      }
      i = j + b(((ViewBase)localObject1).findViewBaseByName("id_separator_special_top"), false);
      break;
      parampgd = ((ViewBase)localObject1).findViewBaseByName("id_separator_special_color_bottom");
      switch (j)
      {
      default: 
        i = a(parampgd, true) + 0;
        break;
      case 2: 
      case 3: 
        i = a(parampgd, false) + 0;
        break;
      }
    }
  }
  
  private static int b(ViewBase paramViewBase, boolean paramBoolean)
  {
    if (paramViewBase == null) {
      return 0;
    }
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      paramViewBase.setVisibility(i);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     opm
 * JD-Core Version:    0.7.0.1
 */