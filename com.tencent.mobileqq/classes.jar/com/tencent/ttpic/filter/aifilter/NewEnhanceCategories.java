package com.tencent.ttpic.filter.aifilter;

import java.util.ArrayList;
import java.util.List;

public enum NewEnhanceCategories
{
  public static String CATEGORY_UNRECOGNIZED;
  public static List<NewEnhanceCategories> newEnhanceTypes;
  public String displayName;
  public String fileName;
  public String filterType;
  public String serverLabel;
  
  static
  {
    BABY = new NewEnhanceCategories("BABY", 2, "baby", "儿童", "儿童", "gaobai_bf.png");
    CROWD = new NewEnhanceCategories("CROWD", 3, "crowd", "合影", "合影", "ziran_cam.png");
    P_LANDSCAPE = new NewEnhanceCategories("P_LANDSCAPE", 4, "plandscape", "人像加风光", "人景", "eftWeiguang_bf.png");
    P_FOOD = new NewEnhanceCategories("P_FOOD", 5, "personfood", "人像加美食", "用餐", "xinxian2_bf.png");
    P_SPORTS = new NewEnhanceCategories("P_SPORTS", 6, "personsports", "人像加运动", "健身", "xuanlan2_bf.png");
    LANDSCAPE = new NewEnhanceCategories("LANDSCAPE", 7, "landscape", "户外", "户外", "xuanlan2_bf.png");
    BUILDING = new NewEnhanceCategories("BUILDING", 8, "building", "建筑", "建筑", "fengzhigu2_bf.png");
    INDOOR = new NewEnhanceCategories("INDOOR", 9, "indoor", "室内", "室内", "musi_cam.png");
    NIGHT = new NewEnhanceCategories("NIGHT", 10, "night", "夜景", "夜景", "xuanlan2_bf.png");
    SKY = new NewEnhanceCategories("SKY", 11, "sky", "天空", "天空", "jidi_bf.png");
    SPORTS = new NewEnhanceCategories("SPORTS", 12, "sports", "运动", "运动", "xuanlan2_bf.png");
    DISHES = new NewEnhanceCategories("DISHES", 13, "fooddishes", "菜肴", "菜肴", "xinxian2_bf.png");
    DESSERT = new NewEnhanceCategories("DESSERT", 14, "fooddessert", "甜点", "甜点", "tianpin2_bf.png");
    BEVERAGE = new NewEnhanceCategories("BEVERAGE", 15, "fooddrink", "饮品", "饮品", "youge_cam.png");
    MEAT = new NewEnhanceCategories("MEAT", 16, "foodmeat", "肉类", "肉类", "lengcui_bf.png");
    WESTERN = new NewEnhanceCategories("WESTERN", 17, "foodwestern", "西餐", "西餐", "xican2_bf.png");
    RESTAURANT = new NewEnhanceCategories("RESTAURANT", 18, "foodrestaurant", "餐厅", "餐厅", "xican2_bf.png");
    STILL_OBJECT = new NewEnhanceCategories("STILL_OBJECT", 19, "object", "静物", "静物", "xican2_bf.png");
    ANIMAL = new NewEnhanceCategories("ANIMAL", 20, "animal", "动物", "动物", "musi_cam.png");
    PLANT = new NewEnhanceCategories("PLANT", 21, "plant", "植物", "植物", "tianpin2_bf.png");
    COMMON = new NewEnhanceCategories("COMMON", 22, "other", "通用", "通用", "ziran_cam.png");
    $VALUES = new NewEnhanceCategories[] { FEMALE, MALE, BABY, CROWD, P_LANDSCAPE, P_FOOD, P_SPORTS, LANDSCAPE, BUILDING, INDOOR, NIGHT, SKY, SPORTS, DISHES, DESSERT, BEVERAGE, MEAT, WESTERN, RESTAURANT, STILL_OBJECT, ANIMAL, PLANT, COMMON };
    CATEGORY_UNRECOGNIZED = "通用";
    newEnhanceTypes = new ArrayList();
    newEnhanceTypes.add(FEMALE);
    newEnhanceTypes.add(MALE);
    newEnhanceTypes.add(BABY);
    newEnhanceTypes.add(CROWD);
    newEnhanceTypes.add(P_LANDSCAPE);
    newEnhanceTypes.add(P_FOOD);
    newEnhanceTypes.add(P_SPORTS);
    newEnhanceTypes.add(LANDSCAPE);
    newEnhanceTypes.add(BUILDING);
    newEnhanceTypes.add(INDOOR);
    newEnhanceTypes.add(NIGHT);
    newEnhanceTypes.add(SKY);
    newEnhanceTypes.add(SPORTS);
    newEnhanceTypes.add(DISHES);
    newEnhanceTypes.add(DESSERT);
    newEnhanceTypes.add(BEVERAGE);
    newEnhanceTypes.add(MEAT);
    newEnhanceTypes.add(WESTERN);
    newEnhanceTypes.add(RESTAURANT);
    newEnhanceTypes.add(STILL_OBJECT);
    newEnhanceTypes.add(ANIMAL);
    newEnhanceTypes.add(PLANT);
    newEnhanceTypes.add(COMMON);
  }
  
  private NewEnhanceCategories(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.filterType = paramString1;
    this.serverLabel = paramString2;
    this.displayName = paramString3;
    this.fileName = paramString4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.aifilter.NewEnhanceCategories
 * JD-Core Version:    0.7.0.1
 */