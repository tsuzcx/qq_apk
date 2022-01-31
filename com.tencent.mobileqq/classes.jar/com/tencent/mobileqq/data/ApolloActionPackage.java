package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class ApolloActionPackage
  extends Entity
{
  public static final int PACKAGE_ID_COLLECT = 4;
  public static final int PACKAGE_ID_ENHANCE = 7;
  public static final int PACKAGE_ID_GAME = 100;
  public static final int PACKAGE_ID_SINGLE = 0;
  public static final int PACKAGE_ID_SLAVE = 6;
  public static final int PACKAGE_ID_WORLD = 5;
  public String endVersion;
  public boolean isUpdate;
  public String mIconSelectedUrl;
  public String mIconUnselectedUrl;
  public String name;
  @unique
  public int packageId;
  public int redFlowId;
  public long redInterval;
  public long redStartTime;
  public int sessionType;
  public String startVersion;
  public int type;
  public long version;
  
  public ApolloActionPackage getCopy()
  {
    ApolloActionPackage localApolloActionPackage = new ApolloActionPackage();
    localApolloActionPackage.mIconSelectedUrl = this.mIconSelectedUrl;
    localApolloActionPackage.mIconUnselectedUrl = this.mIconUnselectedUrl;
    localApolloActionPackage.type = this.type;
    localApolloActionPackage.packageId = this.packageId;
    localApolloActionPackage.sessionType = this.sessionType;
    localApolloActionPackage.version = this.version;
    localApolloActionPackage.startVersion = this.startVersion;
    localApolloActionPackage.endVersion = this.endVersion;
    localApolloActionPackage.isUpdate = this.isUpdate;
    localApolloActionPackage.name = this.name;
    return localApolloActionPackage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.ApolloActionPackage
 * JD-Core Version:    0.7.0.1
 */