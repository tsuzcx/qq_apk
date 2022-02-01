package cooperation.qzone.UndealCount;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashMap;

public class QZoneCountInfo
{
  public long cTime;
  public int countId;
  public boolean existDL;
  public ArrayList<QZoneCountUserInfo> friendList;
  public String friendMsg;
  public ArrayList<Long> friendUinList;
  public boolean hasShow;
  public int iControl;
  public int iShowLevel;
  public String iconUrl;
  public String pushMesssage = "";
  public String reportValue;
  public String schema = "";
  public String strShowMsg;
  public int totalFriendUnread;
  public String trace_info;
  public long uCount;
  
  public QZoneCountInfo()
  {
    this(0, 0, new ArrayList(), "", "");
  }
  
  public QZoneCountInfo(int paramInt1, int paramInt2, ArrayList<QZoneCountUserInfo> paramArrayList, String paramString1, String paramString2)
  {
    this.uCount = paramInt1;
    this.iControl = paramInt2;
    this.friendList = paramArrayList;
    this.friendMsg = paramString1;
    this.totalFriendUnread = 0;
    this.trace_info = paramString2;
  }
  
  public QZoneCountInfo(QZoneCountInfo paramQZoneCountInfo)
  {
    this.uCount = paramQZoneCountInfo.uCount;
    this.iControl = paramQZoneCountInfo.iControl;
    this.friendList = new ArrayList();
    if (paramQZoneCountInfo.friendList != null) {
      this.friendList.addAll(paramQZoneCountInfo.friendList);
    }
    this.friendMsg = paramQZoneCountInfo.friendMsg;
    this.totalFriendUnread = 0;
    this.pushMesssage = paramQZoneCountInfo.pushMesssage;
    this.schema = paramQZoneCountInfo.schema;
    this.trace_info = paramQZoneCountInfo.trace_info;
    this.iconUrl = paramQZoneCountInfo.iconUrl;
    this.countId = paramQZoneCountInfo.countId;
    this.strShowMsg = paramQZoneCountInfo.strShowMsg;
    this.reportValue = paramQZoneCountInfo.reportValue;
    this.cTime = paramQZoneCountInfo.cTime;
    this.iShowLevel = paramQZoneCountInfo.iShowLevel;
    this.hasShow = paramQZoneCountInfo.hasShow;
  }
  
  public static HashMap<Integer, QZoneCountInfo> createFromCursor(Cursor paramCursor)
  {
    if ((paramCursor == null) || (paramCursor.isClosed())) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    if (paramCursor.moveToNext())
    {
      QZoneCountInfo localQZoneCountInfo = new QZoneCountInfo();
      int j = paramCursor.getInt(paramCursor.getColumnIndex("type"));
      localQZoneCountInfo.iControl = paramCursor.getInt(paramCursor.getColumnIndex("icontrol"));
      localQZoneCountInfo.friendMsg = paramCursor.getString(paramCursor.getColumnIndex("friendMsg"));
      localQZoneCountInfo.uCount = paramCursor.getInt(paramCursor.getColumnIndex("ucount"));
      localQZoneCountInfo.trace_info = paramCursor.getString(paramCursor.getColumnIndex("trace_info"));
      localQZoneCountInfo.totalFriendUnread = paramCursor.getInt(paramCursor.getColumnIndex("friendsNum"));
      localQZoneCountInfo.friendList = new ArrayList();
      Object localObject1 = paramCursor.getBlob(paramCursor.getColumnIndex("frienduins"));
      Parcel localParcel;
      if ((localObject1 != null) && (localObject1.length != 0)) {
        localParcel = Parcel.obtain();
      }
      try
      {
        localParcel.unmarshall((byte[])localObject1, 0, localObject1.length);
        localParcel.setDataPosition(0);
        localObject1 = localParcel.readParcelableArray(QZoneCountUserInfo.class.getClassLoader());
        if (localObject1 != null)
        {
          int k = localObject1.length;
          int i = 0;
          while (i < k)
          {
            Object localObject2 = localObject1[i];
            localQZoneCountInfo.friendList.add((QZoneCountUserInfo)localObject2);
            i += 1;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          label295:
          localThrowable.printStackTrace();
          localParcel.recycle();
        }
      }
      finally
      {
        localParcel.recycle();
      }
      if (paramCursor.getInt(paramCursor.getColumnIndex("existDL")) == 1)
      {
        bool = true;
        localQZoneCountInfo.existDL = bool;
        localQZoneCountInfo.pushMesssage = paramCursor.getString(paramCursor.getColumnIndex("pushMsg"));
        localQZoneCountInfo.schema = paramCursor.getString(paramCursor.getColumnIndex("schema"));
        localQZoneCountInfo.iconUrl = paramCursor.getString(paramCursor.getColumnIndex("iconUrl"));
        localQZoneCountInfo.reportValue = paramCursor.getString(paramCursor.getColumnIndex("reportValue"));
        localQZoneCountInfo.strShowMsg = paramCursor.getString(paramCursor.getColumnIndex("showMsg"));
        localQZoneCountInfo.countId = paramCursor.getInt(paramCursor.getColumnIndex("countID"));
        localQZoneCountInfo.cTime = paramCursor.getLong(paramCursor.getColumnIndex("cTime"));
        localQZoneCountInfo.iShowLevel = paramCursor.getInt(paramCursor.getColumnIndex("iShowLevel"));
        if (paramCursor.getInt(paramCursor.getColumnIndex("hasShow")) != 1) {
          break label526;
        }
      }
      label526:
      for (boolean bool = true;; bool = false)
      {
        localQZoneCountInfo.hasShow = bool;
        localHashMap.put(Integer.valueOf(j), localQZoneCountInfo);
        break;
        bool = false;
        break label295;
      }
    }
    return localHashMap;
  }
  
  public ContentValues convertToContentValues()
  {
    int j = 1;
    ContentValues localContentValues = new ContentValues(9);
    localContentValues.put("icontrol", Integer.valueOf(this.iControl));
    localContentValues.put("ucount", Long.valueOf(this.uCount));
    localContentValues.put("friendsNum", Integer.valueOf(this.totalFriendUnread));
    Parcel localParcel = Parcel.obtain();
    Object localObject = null;
    if (this.friendList != null)
    {
      localObject = new QZoneCountUserInfo[this.friendList.size()];
      localParcel.writeParcelableArray((Parcelable[])this.friendList.toArray((Object[])localObject), 0);
      localObject = localParcel.marshall();
    }
    localParcel.recycle();
    localContentValues.put("frienduins", (byte[])localObject);
    localContentValues.put("friendMsg", this.friendMsg);
    localContentValues.put("trace_info", this.trace_info);
    if (this.existDL)
    {
      i = 1;
      localContentValues.put("existDL", Integer.valueOf(i));
      localContentValues.put("pushMsg", this.pushMesssage);
      localContentValues.put("schema", this.schema);
      localContentValues.put("iconUrl", this.iconUrl);
      localContentValues.put("showMsg", this.strShowMsg);
      localContentValues.put("reportValue", this.reportValue);
      localContentValues.put("cTime", Long.valueOf(this.cTime));
      localContentValues.put("iShowLevel", Integer.valueOf(this.iShowLevel));
      if (!this.hasShow) {
        break label269;
      }
    }
    label269:
    for (int i = j;; i = 0)
    {
      localContentValues.put("hasShow", Integer.valueOf(i));
      return localContentValues;
      i = 0;
      break;
    }
  }
  
  public boolean equals(QZoneCountInfo paramQZoneCountInfo)
  {
    if (paramQZoneCountInfo == null) {}
    while (((this.trace_info != null) && (!this.trace_info.equals(paramQZoneCountInfo.trace_info))) || ((paramQZoneCountInfo.trace_info != null) && (!paramQZoneCountInfo.trace_info.equals(this.trace_info))) || ((this.pushMesssage != null) && (!this.pushMesssage.equals(paramQZoneCountInfo.pushMesssage))) || ((this.pushMesssage == null) && (paramQZoneCountInfo.pushMesssage != null)) || ((this.schema != null) && (!this.schema.equals(paramQZoneCountInfo.schema))) || ((this.schema == null) && (paramQZoneCountInfo.schema != null)) || (this.countId != paramQZoneCountInfo.countId) || (!String.valueOf(this.iconUrl).equals(String.valueOf(paramQZoneCountInfo.iconUrl))) || (!String.valueOf(this.strShowMsg).equals(String.valueOf(paramQZoneCountInfo.strShowMsg))) || (!String.valueOf(this.reportValue).equals(String.valueOf(this.reportValue))) || (this.cTime != paramQZoneCountInfo.cTime) || (this.uCount != paramQZoneCountInfo.uCount) || (!this.friendList.equals(paramQZoneCountInfo.friendList))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.UndealCount.QZoneCountInfo
 * JD-Core Version:    0.7.0.1
 */