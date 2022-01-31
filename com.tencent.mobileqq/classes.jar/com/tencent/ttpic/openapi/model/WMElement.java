package com.tencent.ttpic.openapi.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.PointF;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.audio.LocalAudioDataManager;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class WMElement
{
  public static final String ANIMATE_TYPE_ALPHA = "alpha";
  public static final String ANIMATE_TYPE_DITHERING = "dithering";
  public static final String ANIMATE_TYPE_SCALE = "scale";
  protected static final String DB_TYPE = "CheckIn";
  public static final int EDIT_TYPE_EDITABLE = 1;
  protected static final String INT_D = "%d";
  protected static final String LOGIC = "[logic]";
  private static final String TAG = WMElement.class.getSimpleName();
  public static final int TEXT_SIZE_ADJUST = 1;
  public static final int TEXT_SIZE_FIXED = 0;
  private int active = 0;
  public String alignment;
  public PointF anchor;
  public float animateAlphaEnd0;
  public float animateAlphaEnd1;
  public float animateAlphaStart0;
  public float animateAlphaStart1;
  public String animateType;
  private Bitmap[] bitmaps = new Bitmap[2];
  public float blurAmount;
  public int checkinDays = 0;
  public String color;
  public String curShaderBmp;
  public String curValue;
  protected Set<String> dataKeys = new HashSet();
  public String dataPath;
  public int edittype;
  public boolean emboss;
  public RectF finalContentRect = new RectF();
  protected boolean firstDrew = false;
  public String fmtstr;
  public boolean fontBold;
  public int fontFit;
  public boolean fontItalics;
  public String fontName;
  public float fontSize;
  public String fontTexture;
  public int frameDuration;
  public int frames;
  public int height;
  public String id;
  public String imgPath;
  private boolean isContentChanged = false;
  public boolean isNeedShow;
  public boolean isWM260;
  public boolean ischeckin = false;
  public String itemId;
  public int kern;
  public String lastValue;
  public WMLogic logic;
  public String materialId;
  public boolean multiRow;
  public String numberSource;
  public int offsetX;
  public int offsetY;
  public String outerStrokeColor;
  public float outerStrokeSize;
  public int persistence;
  public PointF relativeAnchor;
  public String relativeID;
  public String shaderBmp;
  public String shadowColor;
  public float shadowDx;
  public float shadowDy;
  public float shadowSize;
  public String showCaseMax;
  public String showCaseMin;
  public String sid;
  public String strokeColor;
  public float strokeSize;
  public String textSource;
  public String userValue;
  public int vertical;
  public int width;
  public int wmtype;
  
  WMElement() {}
  
  WMElement(WMElementConfig paramWMElementConfig)
  {
    this.id = paramWMElementConfig.id;
    this.relativeID = paramWMElementConfig.relativeID;
    this.relativeAnchor = paramWMElementConfig.relativeAnchor;
    this.anchor = paramWMElementConfig.anchor;
    this.sid = paramWMElementConfig.sid;
    this.itemId = paramWMElementConfig.itemId;
    this.dataPath = paramWMElementConfig.dataPath;
    this.offsetX = paramWMElementConfig.offsetX;
    this.offsetY = paramWMElementConfig.offsetY;
    this.width = paramWMElementConfig.width;
    this.height = paramWMElementConfig.height;
    this.wmtype = paramWMElementConfig.wmtype;
    this.edittype = paramWMElementConfig.edittype;
    this.fmtstr = paramWMElementConfig.fmtstr;
    this.fontName = paramWMElementConfig.fontName;
    this.fontBold = paramWMElementConfig.fontBold;
    this.fontItalics = paramWMElementConfig.fontItalics;
    this.fontTexture = paramWMElementConfig.fontTexture;
    this.fontSize = paramWMElementConfig.fontSize;
    this.fontFit = paramWMElementConfig.fontFit;
    this.imgPath = paramWMElementConfig.imgPath;
    this.frameDuration = paramWMElementConfig.frameDuration;
    this.frames = paramWMElementConfig.frames;
    this.kern = paramWMElementConfig.kern;
    this.color = paramWMElementConfig.color;
    this.strokeColor = paramWMElementConfig.strokeColor;
    this.strokeSize = paramWMElementConfig.strokeSize;
    this.shadowColor = paramWMElementConfig.shadowColor;
    this.shadowSize = paramWMElementConfig.shadowSize;
    this.shadowDx = paramWMElementConfig.shadowDx;
    this.shadowDy = paramWMElementConfig.shadowDy;
    this.blurAmount = paramWMElementConfig.blurAmount;
    this.alignment = paramWMElementConfig.alignment;
    this.vertical = paramWMElementConfig.vertical;
    this.animateType = paramWMElementConfig.animateType;
    this.shaderBmp = paramWMElementConfig.shaderBmp;
    this.curShaderBmp = paramWMElementConfig.curShaderBmp;
    this.emboss = paramWMElementConfig.emboss;
    this.outerStrokeColor = paramWMElementConfig.outerStrokeColor;
    this.outerStrokeSize = paramWMElementConfig.outerStrokeSize;
    this.multiRow = paramWMElementConfig.multiRow;
    this.logic = paramWMElementConfig.logic;
    this.isWM260 = paramWMElementConfig.isWM260;
    this.animateAlphaEnd0 = paramWMElementConfig.animateAlphaEnd0;
    this.animateAlphaEnd1 = paramWMElementConfig.animateAlphaEnd1;
    this.animateAlphaStart0 = paramWMElementConfig.animateAlphaStart0;
    this.animateAlphaStart1 = paramWMElementConfig.animateAlphaStart1;
    this.persistence = paramWMElementConfig.persistence;
    this.numberSource = paramWMElementConfig.numberSource;
    this.showCaseMin = paramWMElementConfig.showCaseMin;
    this.showCaseMax = paramWMElementConfig.showCaseMax;
    this.textSource = paramWMElementConfig.textSource;
  }
  
  public void add111Days()
  {
    AEModule.getContext().getSharedPreferences("CheckIn", 0).edit().putInt(this.materialId + this.id, this.checkinDays + 111).apply();
    this.checkinDays += 111;
    LogicDataManager.getInstance().mFollowData.put(this.id, String.valueOf(this.checkinDays));
  }
  
  public void addDays(String paramString)
  {
    AEModule.getContext().getSharedPreferences("CheckIn", 0).edit().putInt(this.materialId + this.id, this.checkinDays + 1).apply();
    AEModule.getContext().getSharedPreferences("CheckIn", 0).edit().putString(this.materialId + this.id + "data", paramString).apply();
  }
  
  public void clear()
  {
    if (((this instanceof TextWMElement)) && (this.edittype == 1)) {
      LogicDataManager.getInstance().removeEditableWMElement(this);
    }
    this.dataKeys.clear();
    this.lastValue = null;
    this.firstDrew = false;
    this.isNeedShow = false;
  }
  
  public Bitmap getBitmap()
  {
    return this.bitmaps[this.active];
  }
  
  public String getCheckInDate()
  {
    return AEModule.getContext().getSharedPreferences("CheckIn", 0).getString(this.materialId + this.id + "data", "");
  }
  
  public String getCheckInResetString()
  {
    return "1" + LogicDataManager.getInstance().replaceWithData(this.fmtstr, this.dataKeys, this);
  }
  
  public String getDefault()
  {
    String str1 = "";
    if (this.fmtstr != null) {
      str1 = new String(this.fmtstr);
    }
    String str2 = str1;
    if (this.logic != null) {
      str2 = str1.replace("[logic]", this.logic.getValue(this.userValue, this));
    }
    return LogicDataManager.getInstance().replaceWithData(str2, this.dataKeys, this);
  }
  
  public Bitmap getIdleBitmap()
  {
    return this.bitmaps[(this.active ^ 0x1)];
  }
  
  public String getTitle()
  {
    String str1 = "";
    if (this.fmtstr != null) {
      str1 = new String(this.fmtstr);
    }
    String str2 = str1;
    if (this.logic != null)
    {
      str2 = str1.replace("[logic]", this.logic.getValue(this.userValue, this));
      LogicDataManager.getInstance().mFollowData.put(this.id, String.valueOf(this.logic.getDays()));
    }
    str1 = LogicDataManager.getInstance().replaceWithData(str2, this.dataKeys, this);
    return AEModule.getContext().getSharedPreferences("CheckIn", 0).getString(this.materialId + this.id + "title", str1);
  }
  
  public void init()
  {
    clear();
    if (this.dataPath != null)
    {
      localObject = this.dataPath.split("/");
      if (localObject.length > 0) {
        this.materialId = localObject[(localObject.length - 1)];
      }
    }
    if ((this.width > 0) && (this.height > 0))
    {
      this.bitmaps[0] = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
      this.bitmaps[1] = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
    }
    if (((this instanceof TextWMElement)) && (this.edittype == 1)) {
      LogicDataManager.getInstance().addEditableWMElement(this);
    }
    Pattern localPattern = Pattern.compile("(\\[.+?\\])");
    if (this.wmtype == WMElement.WMType.TEXT.value) {}
    for (Object localObject = this.fmtstr;; localObject = this.imgPath)
    {
      localObject = localPattern.matcher((CharSequence)localObject);
      while (((Matcher)localObject).find()) {
        if (((Matcher)localObject).groupCount() > 0) {
          this.dataKeys.add(((Matcher)localObject).group());
        }
      }
    }
    if ((this.logic != null) && (!TextUtils.isEmpty(this.logic.data))) {
      this.dataKeys.add(this.logic.data);
    }
    if (this.dataKeys.contains("[db]")) {
      LocalAudioDataManager.getInstance().setNeedDB(true);
    }
    if (!TextUtils.isEmpty(this.shaderBmp)) {
      this.curShaderBmp = String.format(this.shaderBmp, new Object[] { Integer.valueOf(0) });
    }
    if (this.dataKeys.contains("[checkin]"))
    {
      this.ischeckin = true;
      localObject = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
      if (getCheckInDate().equals(localObject))
      {
        this.checkinDays = (AEModule.getContext().getSharedPreferences("CheckIn", 0).getInt(this.materialId + this.id, 1) - 1);
        LogicDataManager.getInstance().mFollowData.put(this.id, String.valueOf(this.checkinDays));
      }
    }
    while (this.persistence != 1) {
      for (;;)
      {
        return;
        this.checkinDays = AEModule.getContext().getSharedPreferences("CheckIn", 0).getInt(this.materialId + this.id, 1);
      }
    }
    this.userValue = getTitle();
  }
  
  public boolean isContentChanged()
  {
    return this.isContentChanged;
  }
  
  public void reset() {}
  
  public void resetDays()
  {
    AEModule.getContext().getSharedPreferences("CheckIn", 0).edit().putInt(this.materialId + this.id, 1).apply();
    AEModule.getContext().getSharedPreferences("CheckIn", 0).edit().putString(this.materialId + this.id + "data", "").apply();
    this.checkinDays = 1;
    LogicDataManager.getInstance().mFollowData.put(this.id, String.valueOf(this.checkinDays));
  }
  
  public void saveTitle(String paramString)
  {
    AEModule.getContext().getSharedPreferences("CheckIn", 0).edit().putString(this.materialId + this.id + "title", paramString).apply();
  }
  
  public void setContentChanged(boolean paramBoolean)
  {
    this.isContentChanged = paramBoolean;
  }
  
  public void setDataPath(String paramString)
  {
    this.dataPath = paramString;
  }
  
  public void setIdleBitmap(Bitmap paramBitmap)
  {
    this.bitmaps[(this.active ^ 0x1)] = paramBitmap;
  }
  
  public void swapActiveBitmap()
  {
    this.active ^= 0x1;
  }
  
  public boolean updateBitmap(long paramLong, boolean paramBoolean)
  {
    return updateBitmap(paramLong, paramBoolean, false);
  }
  
  public abstract boolean updateBitmap(long paramLong, boolean paramBoolean1, boolean paramBoolean2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.WMElement
 * JD-Core Version:    0.7.0.1
 */