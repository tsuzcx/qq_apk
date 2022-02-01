package com.tencent.mobileqq.richmediabrowser.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import java.util.ArrayList;

public class AIOFileVideoData
  extends AIOBrowserBaseData
{
  public static final Parcelable.Creator<RichMediaBaseData> CREATOR = new AIOFileVideoData.1();
  public boolean A = false;
  public String B;
  public int C;
  public int D;
  public String E;
  public String F;
  public Bundle G;
  public int H = 0;
  public long I = 0L;
  public String j;
  public String k;
  public String l;
  public long m;
  public int n;
  public int o;
  public String p;
  public ArrayList<String> q = null;
  public long r;
  public String s;
  public boolean t = false;
  public boolean u = false;
  public boolean v = false;
  public String w = null;
  public boolean x = false;
  public boolean y = false;
  public boolean z = false;
  
  public String a()
  {
    int i = this.status;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 6)
              {
                if (i != 7) {
                  return "undefine";
                }
                return "Saving";
              }
              return "Error";
            }
            return "Pause";
          }
          return "Playing";
        }
        return "Buffering";
      }
      return "Downloading";
    }
    return "Nomal";
  }
  
  public int getType()
  {
    return 103;
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    super.readFromParcel(paramParcel);
    this.k = paramParcel.readString();
    this.j = paramParcel.readString();
    this.l = paramParcel.readString();
    this.m = paramParcel.readLong();
    this.n = paramParcel.readInt();
    this.o = paramParcel.readInt();
    int i = paramParcel.readInt();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.v = bool;
    this.B = paramParcel.readString();
    this.C = paramParcel.readInt();
    this.D = paramParcel.readInt();
    this.E = paramParcel.readString();
    this.F = paramParcel.readString();
  }
  
  public void updateProgress(int paramInt)
  {
    this.progress = paramInt;
  }
  
  public void updateStatus(int paramInt)
  {
    this.status = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData
 * JD-Core Version:    0.7.0.1
 */