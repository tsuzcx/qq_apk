package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.util.ArrayList;
import java.util.List;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="cid,bid,source_id")
public class CouponEntity
  extends Entity
{
  public static final int VERIFY_TYPE_BARCODE = 2;
  public static final int VERIFY_TYPE_DIGITAL_CODE = 1;
  public static final int VERIFY_TYPE_SHOWED_AND_VALID = 0;
  public int bid;
  public int cid;
  public String detail;
  public long etime;
  public boolean isNew = false;
  public int is_read_able;
  public int is_valid;
  public String name;
  public String pic;
  public String qlife_url;
  public String qrcode;
  public long rcv_time;
  public String rebate;
  public String shids;
  @notColumn
  public CharSequence shopData;
  @notColumn
  private List<Integer> shopList;
  public int source_id;
  public long stime;
  public String tag;
  public String usage;
  public int veri_type;
  
  public CouponEntity() {}
  
  public CouponEntity(int paramInt1, int paramInt2, String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt3, String paramString3, String paramString4, List<Integer> paramList, int paramInt4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt5, long paramLong3, int paramInt6)
  {
    this.cid = paramInt1;
    this.bid = paramInt2;
    this.name = paramString1;
    this.detail = paramString2;
    this.stime = paramLong1;
    this.etime = paramLong2;
    this.veri_type = paramInt3;
    this.pic = paramString3;
    this.tag = paramString4;
    this.shopList = paramList;
    this.shids = TextUtils.join(",", paramList);
    this.is_valid = paramInt4;
    this.usage = paramString5;
    this.rebate = paramString6;
    this.qrcode = paramString7;
    this.qlife_url = paramString8;
    this.source_id = paramInt5;
    this.rcv_time = paramLong3;
    this.is_read_able = paramInt6;
    this.isNew = false;
  }
  
  public List<Integer> getShopList()
  {
    if (this.shopList == null)
    {
      this.shopList = new ArrayList();
      if (!TextUtils.isEmpty(this.shids))
      {
        String[] arrayOfString = this.shids.split("\\,");
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          this.shopList.add(Integer.valueOf(Integer.parseInt(str)));
          i += 1;
        }
      }
    }
    return this.shopList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.CouponEntity
 * JD-Core Version:    0.7.0.1
 */