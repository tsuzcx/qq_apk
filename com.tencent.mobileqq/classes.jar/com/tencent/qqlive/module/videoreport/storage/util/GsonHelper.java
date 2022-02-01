package com.tencent.qqlive.module.videoreport.storage.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonHelper
{
  public static Gson build()
  {
    GsonBuilder localGsonBuilder = new GsonBuilder();
    localGsonBuilder.registerTypeHierarchyAdapter(Number.class, new GsonHelper.1());
    return localGsonBuilder.create();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.storage.util.GsonHelper
 * JD-Core Version:    0.7.0.1
 */