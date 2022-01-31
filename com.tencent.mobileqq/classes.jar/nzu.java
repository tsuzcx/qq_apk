import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;

public class nzu
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
  
  public static boolean a(Container paramContainer, opw paramopw)
  {
    if ((paramContainer == null) || (paramopw == null)) {}
    qoe localqoe;
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
          localqoe = paramopw.a();
        } while (localqoe == null);
        k = paramopw.g();
        localObject1 = localqoe.b(k);
        localObject2 = localqoe.b(k + 1);
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
        paramopw = ((ViewBase)localObject1).getComLayoutParams();
        if (paramopw.mLayoutHeight >= 0) {
          paramopw.mLayoutHeight = (i + paramopw.mLayoutHeight);
        }
        paramopw = ((ViewBase)localObject1).getComLayoutParams();
        paramContainer.setLayoutParams(new RelativeLayout.LayoutParams(paramopw.mLayoutWidth, paramopw.mLayoutHeight));
        return true;
        paramopw = ((ViewBase)localObject1).findViewBaseByName("id_separator_normal_bottom");
        switch (j)
        {
        default: 
          i = a(paramopw, false);
          break;
        case 2: 
        case 3: 
          i = a(paramopw, true);
        }
      }
    case 2: 
      localObject2 = ((ViewBase)localObject1).findViewBaseByName("id_separator_special_bottom_space");
      localViewBase = ((ViewBase)localObject1).findViewBaseByName("id_separator_special_bottom_line");
      switch (j)
      {
      default: 
        if (paramopw.e() != 70) {}
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
        paramopw = localqoe.b(i);
        i = j;
        if (paramopw == null) {
          break;
        }
        i = j;
        if (a(paramopw.mProteusTemplateBean) != 3) {
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
      paramopw = ((ViewBase)localObject1).findViewBaseByName("id_separator_special_color_bottom");
      switch (j)
      {
      default: 
        i = a(paramopw, true) + 0;
        break;
      case 2: 
      case 3: 
        i = a(paramopw, false) + 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nzu
 * JD-Core Version:    0.7.0.1
 */