package dov.com.qq.im.aeeditor.module.text;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.microrapid.opencv.ImageMainColorData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tavcut.bean.TextEditorData;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.ae.util.AEThemeUtil;
import dov.com.qq.im.aeeditor.AEEditorPath.EDITOR.FILES;
import dov.com.qq.im.aeeditor.manage.AEEditorPagStickerGroup;
import dov.com.qq.im.aeeditor.manage.AEEditorPagStickerInfo;
import dov.com.qq.im.aeeditor.module.filter.AEEditorResourceManager;
import dov.com.qq.im.aeeditor.view.AEEditorQcircleBubbleView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class AEEditorTextControlPanel
  extends FrameLayout
  implements View.OnClickListener, AEEditorEditColorSelected, AETextStickerAdapter.AETextStickerListener, AETextStickerAdapter.ColorBarVisibilityListener
{
  private static final String jdField_a_of_type_JavaLangString = AEEditorPath.EDITOR.FILES.jdField_b_of_type_JavaLangString + File.separator + "text_sticker_thumb" + File.separator;
  private int jdField_a_of_type_Int = -1;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private AEEditorColorSelectorView jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView;
  private AEEditorTextControlPanel.TextStickerControlListener jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel$TextStickerControlListener;
  private AETextStickerAdapter jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter;
  private AETextStickerCategoryAdapter jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerCategoryAdapter;
  private AEEditorQcircleBubbleView jdField_a_of_type_DovComQqImAeeditorViewAEEditorQcircleBubbleView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AEEditorTextControlPanel.5(this);
  private List<AEEditorTextBean> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = AEThemeUtil.a();
  private boolean[] jdField_a_of_type_ArrayOfBoolean = new boolean[9];
  private int jdField_b_of_type_Int;
  private RecyclerView jdField_b_of_type_AndroidSupportV7WidgetRecyclerView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private boolean[] jdField_b_of_type_ArrayOfBoolean = new boolean[9];
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  
  public AEEditorTextControlPanel(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AEEditorTextControlPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AEEditorTextControlPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(@NonNull Context paramContext)
  {
    View localView = View.inflate(paramContext, 2131558596, this);
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView = ((AEEditorColorSelectorView)localView.findViewById(2131364977));
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.setColorSelectedListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131378495));
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2131378496));
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(paramContext, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.setAutoMeasureEnabled(false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new LinearLayoutManager(paramContext, 0, false));
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
  }
  
  private void a(RecyclerView paramRecyclerView, int paramInt)
  {
    int i = paramRecyclerView.getChildLayoutPosition(paramRecyclerView.getChildAt(0));
    int j = paramRecyclerView.getChildLayoutPosition(paramRecyclerView.getChildAt(paramRecyclerView.getChildCount() - 1));
    if (paramInt < i) {
      paramRecyclerView.smoothScrollToPosition(paramInt);
    }
    do
    {
      return;
      if (paramInt > j) {
        break;
      }
      paramInt -= i;
    } while ((paramInt < 0) || (paramInt >= paramRecyclerView.getChildCount()));
    paramRecyclerView.smoothScrollBy(paramRecyclerView.getChildAt(paramInt).getLeft(), 0);
    return;
    paramRecyclerView.smoothScrollToPosition(paramInt);
    this.jdField_e_of_type_Int = paramInt;
    this.jdField_e_of_type_Boolean = true;
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!paramBoolean) {
              break;
            }
          } while (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.getVisibility() == 0);
          this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.setVisibility(0);
        } while (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel$TextStickerControlListener == null);
        this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel$TextStickerControlListener.c(true);
        return;
      } while (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.getVisibility() != 0);
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.setVisibility(8);
    } while (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel$TextStickerControlListener == null);
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel$TextStickerControlListener.c(false);
  }
  
  private int b(String paramString, List<AEEditorPagStickerGroup> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if (paramString.equals(((AEEditorPagStickerGroup)paramList.get(i)).stickerGroupId)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void c(int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfBoolean[this.jdField_c_of_type_Int] != 0) && (this.jdField_b_of_type_ArrayOfBoolean[this.jdField_c_of_type_Int] != 0) && (this.jdField_b_of_type_Boolean) && (this.jdField_d_of_type_Int != paramInt))
    {
      this.jdField_d_of_type_Int = paramInt;
      h();
      g();
    }
  }
  
  public static void f()
  {
    ThreadManager.getFileThreadHandler().post(new AEEditorTextControlPanel.8());
  }
  
  private void g()
  {
    ThreadManager.getFileThreadHandler().post(new AEEditorTextControlPanel.1(this));
  }
  
  private void h()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      AEEditorTextBean localAEEditorTextBean = (AEEditorTextBean)localIterator.next();
      if (localAEEditorTextBean.type == 1) {
        localAEEditorTextBean.thumbPath = (jdField_a_of_type_JavaLangString + this.jdField_b_of_type_JavaLangString + "_" + localAEEditorTextBean.id + ".png");
      }
    }
    ThreadManager.getUIHandler().post(new AEEditorTextControlPanel.6(this));
  }
  
  private void i()
  {
    AEEditorTextControlPanel.7 local7 = new AEEditorTextControlPanel.7(this);
    ThreadManager.getUIHandler().post(local7);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(AEEditorTextBean paramAEEditorTextBean)
  {
    int i = 0;
    if (paramAEEditorTextBean.aiColorIndex >= 0) {
      i = (paramAEEditorTextBean.aiColorIndex + 3) % 4;
    }
    for (;;)
    {
      Integer localInteger = (Integer)this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.a().get(i);
      if (localInteger == null) {
        break;
      }
      return localInteger.intValue();
      AEQLog.d("AEEditorTextControlPanel", "[getTextLightnessByAEEditorTextBean] position is default");
    }
    AEQLog.d("AEEditorTextControlPanel", "[getColorByAEEditorTextBean] error !!!!");
    return paramAEEditorTextBean.backgroundColor;
  }
  
  public int a(@NonNull String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      AEEditorTextBean localAEEditorTextBean = (AEEditorTextBean)localIterator.next();
      if (paramString.equals(localAEEditorTextBean.id)) {
        return localAEEditorTextBean.type;
      }
    }
    AEQLog.d("AEEditorTextControlPanel", "[getTypeByID] ERROR !!!!");
    return 0;
  }
  
  public int a(String paramString, List<AEEditorTextBean> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if (paramString.equals(((AEEditorTextBean)paramList.get(i)).id)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  @Nullable
  public Integer a(int paramInt, @Nullable AEEditorTextBean paramAEEditorTextBean)
  {
    Float localFloat = (Float)this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.c().get(paramInt);
    AEQLog.a("AEEditorTextControlPanel", "[getTextColorByAEEditorTextBean] lightness:" + localFloat);
    if (localFloat != null)
    {
      if (localFloat.floatValue() <= 0.8F) {
        return Integer.valueOf(-1);
      }
      return Integer.valueOf(AEEditorColorSelectorView.jdField_b_of_type_Int);
    }
    if (paramAEEditorTextBean != null)
    {
      if (paramAEEditorTextBean.backgroundColor != -1) {
        return Integer.valueOf(-1);
      }
      return Integer.valueOf(AEEditorColorSelectorView.jdField_b_of_type_Int);
    }
    return null;
  }
  
  public String a(int paramInt)
  {
    String str = "none";
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.a().contains(Integer.valueOf(paramInt))) {
      str = "ai_color";
    }
    while (!this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.b().contains(Integer.valueOf(paramInt))) {
      return str;
    }
    return "common_color";
  }
  
  public List<AEEditorTextBean> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 3))
    {
      if (a())
      {
        setIsNeedCreateThumbImage(2);
        this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.b();
      }
    }
    else {
      return;
    }
    setIsNeedCreateThumbImage(3);
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.a();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView != null)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.a(Integer.valueOf(paramInt));
      return;
    }
    AEQLog.d("AEEditorTextControlPanel", "[selectColor] mAEEditorColorSelectorView null");
  }
  
  public void a(int paramInt, @NonNull AEEditorTextBean paramAEEditorTextBean)
  {
    switch (paramAEEditorTextBean.type)
    {
    }
    do
    {
      return;
    } while (!this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel$TextStickerControlListener.a(paramAEEditorTextBean));
    try
    {
      if (Integer.parseInt(paramAEEditorTextBean.interactive) > 0)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("ext1", paramAEEditorTextBean.id);
        ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 77, 1, 0, localHashMap, null, null);
      }
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter != null)
      {
        this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter.c(paramInt);
        this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel$TextStickerControlListener.a(paramInt, paramAEEditorTextBean);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        AEQLog.a("AEEditorTextControlPanel", "exception:", localException);
      }
      throw new RuntimeException("mTextStickerAdapter null");
    }
  }
  
  public void a(int paramInt, List<ImageMainColorData> paramList, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView != null) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.a(paramList, paramBoolean);
      }
      this.jdField_a_of_type_ArrayOfBoolean[paramInt] = true;
      c(paramInt);
    }
  }
  
  public void a(@Nullable TextEditorData paramTextEditorData)
  {
    if (paramTextEditorData == null)
    {
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter != null) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter.a(null);
      }
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView != null) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.a(null);
      }
      d();
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter != null) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter.a(paramTextEditorData.getItemID());
      }
      Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      AEEditorTextBean localAEEditorTextBean;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localAEEditorTextBean = (AEEditorTextBean)((Iterator)localObject).next();
      } while (!localAEEditorTextBean.id.equals(paramTextEditorData.getItemID()));
      for (localObject = AEEditorTextBean.updateTextBeanByStickerConfig(localAEEditorTextBean, AEEditorResourceManager.a().a(AEEditorResourceManager.a().d(paramTextEditorData.getItemID()))); localObject != null; localObject = null)
      {
        if (((AEEditorTextBean)localObject).type == 0)
        {
          this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.a(Integer.valueOf(paramTextEditorData.getTextColor()));
          return;
        }
        if (paramTextEditorData.getColorList().get("bgcolor") != null) {}
        for (int i = ((Integer)paramTextEditorData.getColorList().get("bgcolor")).intValue();; i = ((AEEditorTextBean)localObject).backgroundColor)
        {
          this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.a(Integer.valueOf(i));
          return;
        }
      }
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel$TextStickerControlListener.a(paramString1, paramInt1, paramInt2, paramString2);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      a(false);
    }
    do
    {
      return;
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.setStickerId(paramString);
    } while (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.getVisibility() == 0);
    i();
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.a().iterator();
    boolean bool = true;
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if ((bool) && (localInteger != null)) {}
      for (bool = true; !bool; bool = false) {
        return bool;
      }
    }
    return bool;
  }
  
  public int b(@NonNull AEEditorTextBean paramAEEditorTextBean)
  {
    int i = 0;
    if (paramAEEditorTextBean.aiColorIndex >= 0) {
      i = (paramAEEditorTextBean.aiColorIndex + 3) % 4;
    }
    Integer localInteger;
    for (;;)
    {
      localInteger = a(i, paramAEEditorTextBean);
      if (localInteger != null) {
        break;
      }
      return paramAEEditorTextBean.textColor;
      AEQLog.d("AEEditorTextControlPanel", "[getTextLightnessByAEEditorTextBean] position is default");
    }
    return localInteger.intValue();
  }
  
  public void b()
  {
    Object localObject1;
    if (!this.jdField_c_of_type_Boolean)
    {
      if ((AEEditorResourceManager.a().c()) && (this.jdField_b_of_type_Boolean)) {
        setIsNeedCreateThumbImage(1);
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        localObject1 = AEEditorResourceManager.a().a();
        Iterator localIterator1 = ((List)localObject1).iterator();
        while (localIterator1.hasNext())
        {
          AEEditorPagStickerGroup localAEEditorPagStickerGroup = (AEEditorPagStickerGroup)localIterator1.next();
          Iterator localIterator2 = localAEEditorPagStickerGroup.stickerInfoList.iterator();
          while (localIterator2.hasNext())
          {
            Object localObject2 = (AEEditorPagStickerInfo)localIterator2.next();
            ((AEEditorPagStickerInfo)localObject2).parentId = localAEEditorPagStickerGroup.stickerGroupId;
            localObject2 = AEEditorTextBean.createTextBeanByStickerInfo((AEEditorPagStickerInfo)localObject2);
            if (localObject2 != null) {
              this.jdField_a_of_type_JavaUtilList.add(localObject2);
            }
          }
        }
        setIsNeedCreateThumbImage(0);
      }
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerCategoryAdapter = new AETextStickerCategoryAdapter();
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerCategoryAdapter);
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerCategoryAdapter.a((List)localObject1);
      if (!this.jdField_b_of_type_Boolean) {
        break label303;
      }
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.b();
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter = new AETextStickerAdapter(this, this);
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter.b(this.jdField_b_of_type_Int);
      this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter);
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerCategoryAdapter.a(new AEEditorTextControlPanel.2(this, (List)localObject1));
      this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new AEEditorTextControlPanel.3(this, (List)localObject1));
      localObject1 = (SimpleItemAnimator)this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator();
      if (localObject1 != null) {
        ((SimpleItemAnimator)localObject1).setSupportsChangeAnimations(false);
      }
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerCategoryAdapter.a(0);
      return;
      label303:
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorColorSelectorView.a();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_ArrayOfBoolean[paramInt] = true;
    c(paramInt);
  }
  
  public void c()
  {
    a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter.a(), (AEEditorTextBean)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter.a()));
  }
  
  public void d()
  {
    a(false);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter.a();
    }
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setImageInfo(int paramInt, String paramString)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void setIsChooseImage(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setIsNeedCreateThumbImage(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter.a(paramInt);
    }
  }
  
  public void setPageId(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setStickerCount(int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAETextStickerAdapter.d(paramInt);
    }
  }
  
  public void setTextStickerControlListener(AEEditorTextControlPanel.TextStickerControlListener paramTextStickerControlListener)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel$TextStickerControlListener = paramTextStickerControlListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorTextControlPanel
 * JD-Core Version:    0.7.0.1
 */