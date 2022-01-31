package me.ele.uetool;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import me.ele.uetool.base.DimenUtil;
import me.ele.uetool.base.Element;
import me.ele.uetool.base.IAttrs;
import me.ele.uetool.base.item.AddMinusEditItem;
import me.ele.uetool.base.item.BitmapItem;
import me.ele.uetool.base.item.EditTextItem;
import me.ele.uetool.base.item.Item;
import me.ele.uetool.base.item.SwitchItem;
import me.ele.uetool.base.item.TextItem;
import me.ele.uetool.util.Util;
import me.ele.uetool.util.ViewKnife;

public class UETCore
  implements IAttrs
{
  private static final String TAG = "UETCore";
  private static boolean devFlag = false;
  public static List<String> reason;
  
  public static boolean getDevFlag()
  {
    return devFlag;
  }
  
  public static void setDevFlag(boolean paramBoolean)
  {
    devFlag = paramBoolean;
  }
  
  public List<Item> getAttrs(Element paramElement)
  {
    ArrayList localArrayList = new ArrayList();
    View localView = paramElement.getView();
    localArrayList.add(new SwitchItem("移动模式", paramElement, 2));
    localArrayList.add(new SwitchItem("多选模式", paramElement, 6));
    boolean bool;
    if (localView.getVisibility() == 0) {
      bool = false;
    }
    for (;;)
    {
      localArrayList.add(new SwitchItem("移除", paramElement, 7, bool));
      try
      {
        if (Build.VERSION.SDK_INT >= 16)
        {
          localObject1 = new SwitchItem("背景色板", paramElement, 0);
          ((SwitchItem)localObject1).setCallBack(new UETCore.1(this, localView));
          localArrayList.add(localObject1);
        }
        localArrayList.add(new TextItem("数据摘要", "发送好友", new UETCore.2(this)));
        localArrayList.add(new TextItem("数据摘要", "删除修改缓存", new UETCore.3(this)));
        Object localObject1 = UETCore.AttrsManager.createAttrs(localView);
        if (localObject1 != null) {
          localArrayList.addAll(((IAttrs)localObject1).getAttrs(paramElement));
        }
        localObject1 = ViewKnife.getMargin(paramElement);
        localArrayList.add(new AddMinusEditItem("上外边距（dp）", paramElement, 10, DimenUtil.px2dip(localObject1[1])));
        localArrayList.add(new AddMinusEditItem("左外边距（dp）", paramElement, 11, DimenUtil.px2dip(localObject1[0])));
        localObject1 = new EditTextItem("透明度", paramElement, -1, String.valueOf(localView.getAlpha()));
        ((EditTextItem)localObject1).setCallBack(new UETCore.4(this));
        localArrayList.add(localObject1);
        try
        {
          localObject3 = Util.getBackground(localView);
          if ((localObject3 instanceof String)) {
            break label650;
          }
          if (localObject3 != null) {
            break label609;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject3;
            localException2.printStackTrace();
            continue;
            Object localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "null";
            }
          }
        }
        localObject1 = new EditTextItem("背景颜色", paramElement, -1, (String)localObject1);
        ((EditTextItem)localObject1).setCallBack(new UETCore.5(this));
        localArrayList.add(localObject1);
        localArrayList.add(new AddMinusEditItem("宽（dp）", paramElement, 4, DimenUtil.px2dip(localView.getWidth())));
        localArrayList.add(new AddMinusEditItem("高（dp）", paramElement, 5, DimenUtil.px2dip(localView.getHeight())));
        localArrayList.add(new AddMinusEditItem("左内边距（dp）", paramElement, 6, DimenUtil.px2dip(localView.getPaddingLeft())));
        localArrayList.add(new AddMinusEditItem("右内边距（dp）", paramElement, 7, DimenUtil.px2dip(localView.getPaddingRight())));
        localArrayList.add(new AddMinusEditItem("上内边距（dp）", paramElement, 8, DimenUtil.px2dip(localView.getPaddingTop())));
        localArrayList.add(new AddMinusEditItem("下内边距（dp）", paramElement, 9, DimenUtil.px2dip(localView.getPaddingBottom())));
        localObject1 = new SwitchItem("开发者属性", paramElement, 0, devFlag);
        ((SwitchItem)localObject1).setCallBack(null);
        localArrayList.add(localObject1);
        if (devFlag) {
          localArrayList.addAll(new UETCore.DevAttrs().getAttrs(paramElement));
        }
        return localArrayList;
        bool = true;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localException1.printStackTrace();
          continue;
          label609:
          if ((localObject3 instanceof Bitmap)) {
            localArrayList.add(new BitmapItem("背景图片", (Bitmap)localObject3));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.UETCore
 * JD-Core Version:    0.7.0.1
 */