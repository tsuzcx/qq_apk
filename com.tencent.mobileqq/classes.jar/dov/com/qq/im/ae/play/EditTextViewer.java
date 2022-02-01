package dov.com.qq.im.ae.play;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import bgmg;
import bnox;
import bnxa;
import bnxg;
import bnxh;
import bnxi;
import bnxj;
import bnxk;
import bnyh;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetFontDataRsp;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.openapi.model.TextWMElement;
import com.tencent.ttpic.openapi.util.WMTextDrawer;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import com.tencent.ttpic.videoshelf.model.edit.NodeText;
import java.io.File;

public class EditTextViewer
  extends ImageView
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = EditTextViewer.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayerDrawable jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable;
  private bnxa jdField_a_of_type_Bnxa;
  private bnxj jdField_a_of_type_Bnxj;
  private bnxk jdField_a_of_type_Bnxk;
  private TextWMElement jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement = new TextWMElement();
  private NodeItem jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem = new NodeItem();
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = true;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  
  public EditTextViewer(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    setOnClickListener(this);
    this.jdField_c_of_type_Boolean = true;
    setBackgroundDrawable(getResources().getDrawable(2130837683));
    this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable = ((LayerDrawable)getResources().getDrawable(2130837682));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.findDrawableByLayerId(2131368325);
  }
  
  private String a(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext == null) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return "";
    }
    paramContext = paramContext.getFilesDir().getAbsolutePath() + File.separator + "temp.ttf";
    bgmg.a(paramArrayOfByte, paramContext);
    return paramContext;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new EditTextViewer.5(this, paramInt));
  }
  
  private void a(Canvas paramCanvas)
  {
    if (!this.jdField_d_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.setBounds(0, 0, getWidth(), getHeight());
    this.jdField_a_of_type_AndroidGraphicsDrawableLayerDrawable.draw(paramCanvas);
  }
  
  private void a(GetFontDataRsp paramGetFontDataRsp)
  {
    paramGetFontDataRsp = a(getContext(), paramGetFontDataRsp.FontData);
    if (!TextUtils.isEmpty(paramGetFontDataRsp))
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.fontName = paramGetFontDataRsp;
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.isLocalFont = false;
    }
    try
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.wmTextDrawer.drawTextToBitmap(this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement, b(), false, true);
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap = this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.getBitmap();
      if (!TextUtils.isEmpty(paramGetFontDataRsp))
      {
        a(paramGetFontDataRsp);
        this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.fontName = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.fontName;
        this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.isLocalFont = true;
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        Log.e(jdField_a_of_type_JavaLangString, "drawText of drawTextToBitmap Error, maybe use a recycle bitmap!");
      }
    }
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    paramString = new File(paramString);
    boolean bool1 = bool2;
    if (paramString.exists())
    {
      bool1 = bool2;
      if (paramString.isFile())
      {
        bool1 = bool2;
        if (paramString.delete()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private String b()
  {
    String str;
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.userValue != null) {
      str = this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.userValue;
    }
    do
    {
      return str;
      str = "";
    } while (this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.fmtstr == null);
    return new String(this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.fmtstr);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement != null)
    {
      this.jdField_a_of_type_Bnxa = new bnxa(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_Bnxa.a(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextMaxCount);
      this.jdField_a_of_type_Bnxa.a(this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement, this.jdField_c_of_type_Boolean);
      this.jdField_a_of_type_Bnxa.a(new bnxg(this));
      this.jdField_a_of_type_Bnxa.show();
      this.jdField_a_of_type_Bnxa.setOnDismissListener(new bnxh(this));
    }
  }
  
  private void e()
  {
    String str1 = this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.fontName;
    String str2 = this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.userValue;
    AppInterface localAppInterface = QQStoryContext.a();
    localAppInterface.addObserver(new bnxi(this, localAppInterface, str2));
    ((bnox)localAppInterface.getBusinessHandler(3)).a(str1, str2);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.width, this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.height, Bitmap.Config.ARGB_8888);
    }
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.cropBitmap = null;
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap != null) {
      setImageBitmap(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap);
    }
    if (this.jdField_a_of_type_Bnxk != null) {
      this.jdField_a_of_type_Bnxk.b(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem);
    }
    setTextSelected(true);
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Bnxj != null) {
      this.jdField_a_of_type_Bnxj.a();
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Bnxj != null) {
      this.jdField_a_of_type_Bnxj.b();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeGroupID;
  }
  
  public Bitmap a()
  {
    if (!this.jdField_b_of_type_Boolean) {
      a();
    }
    try
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.wmTextDrawer.drawTextToBitmap(this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement, b(), false, true);
      return this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.getBitmap();
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        Log.e(jdField_a_of_type_JavaLangString, "renderBitmap of drawTextToBitmap Error, maybe use a recycle bitmap!");
      }
    }
  }
  
  public NodeItem a()
  {
    return this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem;
  }
  
  public void a()
  {
    boolean bool2 = false;
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement == null)
    {
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    label64:
    boolean bool1;
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.id))
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.id = ("text" + this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeID);
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.relativeID = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.relativeID;
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.relativeAnchor = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.relativeAnchor;
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.anchor = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.anchor;
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.offsetX = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.offsetX;
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.offsetY = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.offsetY;
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.width = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.width;
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.height = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.height;
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.edittype = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.editType;
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.fontSize = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.fontSize;
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.fontFit = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.fontFit;
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.wmtype = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.wmtype;
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.fmtstr = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.fmtstr;
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.fontName = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.fontName;
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.color = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.color;
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.alignment = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.alignment;
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.vertical = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.vertical;
      TextWMElement localTextWMElement = this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement;
      if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.fontBold != 0) {
        break label592;
      }
      bool1 = false;
      label356:
      localTextWMElement.fontBold = bool1;
      localTextWMElement = this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement;
      if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.fontItalics != 0) {
        break label597;
      }
      bool1 = bool2;
      label381:
      localTextWMElement.fontItalics = bool1;
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.strokeColor = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.strokeColor;
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.strokeSize = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.strokeSize;
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.outerStrokeColor = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.outerStrokeColor;
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.outerStrokeSize = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.outerStrokeSize;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.shadowColor)) {
        break label602;
      }
    }
    label592:
    label597:
    label602:
    for (this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.shadowColor = "#00000000";; this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.shadowColor = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.shadowColor)
    {
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.shadowDx = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.shadowDx;
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.shadowDy = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.shadowDy;
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.blurAmount = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.blurAmount;
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.numberSource = "";
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.init();
      this.jdField_b_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextMaxCount > 0) {
        break;
      }
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextMaxCount = 10;
      return;
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.id = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.id;
      break label64;
      bool1 = true;
      break label356;
      bool1 = true;
      break label381;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = 0;
    int k = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap.getWidth();
    int j = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap.getHeight();
    if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup != null) {
      if ("left".equals(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.alignment))
      {
        paramInt1 = paramInt2 / 2 - j / 2;
        paramInt2 = i;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(paramInt2, paramInt1);
      setImageMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
      return;
      if ("right".equals(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.alignment))
      {
        i = paramInt1 - k;
        paramInt1 = paramInt2 / 2 - j / 2;
        paramInt2 = i;
      }
      else
      {
        i = paramInt1 / 2 - k / 2;
        paramInt1 = paramInt2 / 2 - j / 2;
        paramInt2 = i;
        continue;
        paramInt1 = 0;
        paramInt2 = i;
      }
    }
  }
  
  public void a(String paramString)
  {
    if (!DeviceUtils.isNetworkAvailable(AEModule.getContext())) {
      QQToast.a(getContext(), 2131689757, 1).a();
    }
    label131:
    for (;;)
    {
      return;
      if (!this.jdField_b_of_type_Boolean) {
        a();
      }
      if (TextUtils.isEmpty(paramString)) {}
      for (this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.userValue = "";; this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.userValue = paramString)
      {
        if (this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.userValue.equals(this.jdField_b_of_type_JavaLangString)) {
          break label131;
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.userValue)) {
          break label133;
        }
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.userValue;
        f();
        g();
        if (this.jdField_a_of_type_Bnxk == null) {
          break;
        }
        this.jdField_a_of_type_Bnxk.c(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem);
        return;
      }
    }
    label133:
    h();
    new Thread(new EditTextViewer.3(this)).start();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelTextWMElement.clear();
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap != null) && (!this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap.isRecycled())) {
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap.recycle();
    }
    if ((this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.cropBitmap != null) && (!this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.cropBitmap.isRecycled())) {
      this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.cropBitmap.recycle();
    }
    setImageBitmap(null);
    b();
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void onClick(View paramView)
  {
    if (!this.jdField_b_of_type_Boolean) {
      a();
    }
    d();
    setTextSelected(false);
    bnyh.a().f();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = 0;
    label197:
    for (;;)
    {
      try
      {
        int m;
        int i;
        int n;
        int k;
        if ((this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap != null) && (getWidth() != 0) && (getHeight() != 0))
        {
          m = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap.getWidth();
          i = this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap.getHeight();
          n = getWidth();
          k = getHeight();
          if (this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup == null) {
            break label197;
          }
          if ("left".equals(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.alignment))
          {
            i = k / 2 - i / 2;
            this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(j, i);
            setImageMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
          }
        }
        else
        {
          super.onDraw(paramCanvas);
          a(paramCanvas);
          return;
        }
        if ("right".equals(this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.alignment))
        {
          j = n - m;
          i = k / 2 - i / 2;
        }
        else
        {
          j = n / 2 - m / 2;
          k /= 2;
          i /= 2;
          i = k - i;
          continue;
          i = 0;
        }
      }
      catch (Throwable paramCanvas)
      {
        return;
      }
    }
  }
  
  public void setActionBarHeight(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setMaterialId(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public void setNodeBitmap(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.bitmap = paramBitmap;
  }
  
  public void setNodeInfo(NodeItem paramNodeItem)
  {
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeID = paramNodeItem.nodeID;
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeGroupID = paramNodeItem.nodeGroupID;
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.once = paramNodeItem.once;
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.maskRect = paramNodeItem.maskRect;
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextMaxCount = paramNodeItem.nodeTextMaxCount;
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.zIndex = paramNodeItem.zIndex;
    this.jdField_a_of_type_ComTencentTtpicVideoshelfModelEditNodeItem.nodeTextGroup.copyFrom(paramNodeItem.nodeTextGroup);
  }
  
  public void setOnDownloadDialogListener(bnxj parambnxj)
  {
    this.jdField_a_of_type_Bnxj = parambnxj;
  }
  
  public void setOnSaveTextInfoListener(bnxk parambnxk)
  {
    this.jdField_a_of_type_Bnxk = parambnxk;
  }
  
  public void setTemplateID(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void setTextSelected(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.EditTextViewer
 * JD-Core Version:    0.7.0.1
 */