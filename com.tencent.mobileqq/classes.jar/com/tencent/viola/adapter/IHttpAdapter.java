package com.tencent.viola.adapter;

public abstract interface IHttpAdapter
{
  public abstract void sendRequest(HttpRequset paramHttpRequset, IHttpAdapter.OnHttpListener paramOnHttpListener, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.adapter.IHttpAdapter
 * JD-Core Version:    0.7.0.1
 */