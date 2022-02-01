package cooperation.qzone.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RedTouchExtendButton$RedInfo
  implements Parcelable
{
  public static final Parcelable.Creator<RedInfo> CREATOR = new RedTouchExtendButton.RedInfo.1();
  public static final int RED_TOUCH_IMAGE = 3;
  public static final int RED_TOUCH_NONE = 100;
  public static final int RED_TOUCH_RED_POINT = 0;
  public static final int RED_TOUCH_TEXT = 4;
  public String desc;
  public boolean isNew;
  public String redText;
  public int redType;
  public int resId;
  public String resUrl;
  
  public RedTouchExtendButton$RedInfo() {}
  
  public RedTouchExtendButton$RedInfo(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.isNew = bool;
    this.redType = paramParcel.readInt();
    this.resId = paramParcel.readInt();
    this.redText = paramParcel.readString();
    this.resUrl = paramParcel.readString();
    this.desc = paramParcel.readString();
  }
  
  public RedTouchExtendButton$RedInfo(RedInfo paramRedInfo)
  {
    if (paramRedInfo != null)
    {
      this.isNew = paramRedInfo.isNew;
      this.redType = paramRedInfo.redType;
      this.resId = paramRedInfo.resId;
      this.redText = paramRedInfo.redText;
      this.resUrl = paramRedInfo.resUrl;
      this.desc = paramRedInfo.desc;
    }
  }
  
  private boolean equals(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) && (paramObject2 == null)) {
      return true;
    }
    return (paramObject1 != null) && (paramObject1.equals(paramObject2));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof RedInfo)) {
      return false;
    }
    paramObject = (RedInfo)paramObject;
    boolean bool1 = bool2;
    if (equals(Boolean.valueOf(paramObject.isNew), Boolean.valueOf(this.isNew)))
    {
      bool1 = bool2;
      if (equals(paramObject.redText, this.redText))
      {
        bool1 = bool2;
        if (equals(Integer.valueOf(paramObject.redType), Integer.valueOf(this.redType)))
        {
          bool1 = bool2;
          if (equals(paramObject.resUrl, this.resUrl))
          {
            bool1 = bool2;
            if (equals(paramObject.desc, this.desc))
            {
              bool1 = bool2;
              if (equals(Integer.valueOf(paramObject.resId), Integer.valueOf(this.resId))) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.widget.RedTouchExtendButton.RedInfo
 * JD-Core Version:    0.7.0.1
 */